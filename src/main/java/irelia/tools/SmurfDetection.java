package irelia.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.match.Match;
import irelia.data.summoner.Summoner;

public class SmurfDetection {

    class JSNode {
        private String id;

        public JSNode() {

        }

        public JSNode(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            JSNode other = (JSNode) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

        private SmurfDetection getEnclosingInstance() {
            return SmurfDetection.this;
        }

    }

    class JSEdge {
        private String from;
        private String to;

        public JSEdge() {

        }

        public JSEdge(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

    }

    class JSData {
        private Set<JSNode> nodes;
        private List<JSEdge> edges;

        public JSData() {

        }

        public JSData(Set<JSNode> nodes, List<JSEdge> edges) {
            this.nodes = nodes;
            this.edges = edges;
        }

        public Set<JSNode> getNodes() {
            return nodes;
        }

        public void setNodes(Set<JSNode> nodes) {
            this.nodes = nodes;
        }

        public List<JSEdge> getEdges() {
            return edges;
        }

        public void setEdges(List<JSEdge> edges) {
            this.edges = edges;
        }

    }

    private ObjectMapper mapper;
    private Irelia irelia;
    private final static int NB_DAY = 4;
    private HashMap<String, Match> cache = new HashMap<>();

    public SmurfDetection(Irelia irelia) {
        this.irelia = irelia;
        this.mapper = new ObjectMapper();
    }

    public void report(Account account) throws IOException {
        JSData data = startDetection(account);
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream in = loader.getResourceAsStream("template/smurfReport.html");
        String template = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        template = template.replace("$riotId", account.getRiotId());
        template = template.replace("$data", mapper.writeValueAsString(data));
        File out = new File("out/report.html");
        BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        writer.write(template);
        writer.close();
    }

    public JSData detect(Account account) {
        System.out.println("Smurf detection");
        Summoner summoner = irelia.summoner().byPuuid(account.getPuuid()).join();
        System.out.println("Level detection : %d%%".formatted(Math.max(130 - summoner.getSummonerLevel(), 0)));
        List<String> ids = irelia.match().byPuuid(account.getPuuid(),
                (System.currentTimeMillis() - 1000 * 3600 * 24 * NB_DAY) / 1000, System.currentTimeMillis() / 1000)
                .join();
        Map<String, Match> matchs = new HashMap<>();

        // Chargement des matchs des 7 derniers jours
        for (String id : ids) {
            Match match = irelia.match().byId(id).join();
            matchs.put(match.getMetadata().getMatchId(), match);
        }

        // Chargement des matchs des
        Map<Account, Integer> countMap = new HashMap<>();
        for (Entry<String, Match> entry : matchs.entrySet()) {
            entry.getValue().getInfo().getParticipants().forEach(participant -> {
                countMap.merge(participant.getAccount(), 1, Integer::sum);
            });
            ;
        }
        Set<JSNode> nodes = new HashSet<>();
        List<JSEdge> edges = new ArrayList<>();

        for (Entry<Account, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() <= 1)
                continue;
            nodes.add(new JSNode(entry.getKey().getRiotId()));
            if (entry.getKey().equals(account))
                continue;
            edges.add(new JSEdge(account.getRiotId(), entry.getKey().getRiotId()));
        }
        return new JSData(nodes, edges);
    }

    public JSData startDetection(Account account) {
        JSData data = new JSData(new HashSet<>(), new ArrayList<>());
        recursivFriendDetection(account, 3, data);
        return data;

    }

    public void recursivFriendDetection(Account account, int depth, JSData data) {
        if (depth == 0) {
            return;
        }
        System.out.println("-> Detections des amis de " + account.getRiotId());
        List<String> ids = irelia.match().byPuuid(account.getPuuid(),
                (System.currentTimeMillis() - 1000 * 3600 * 24 * NB_DAY) / 1000, System.currentTimeMillis() / 1000)
                .join();
        Map<String, Match> matchs = new HashMap<>();
        for (String id : ids) {
            Match match = cache.get(id);
            if (match == null) {
                match = irelia.match().byId(id).join();
                cache.put(id, match);
            }
            matchs.put(id, match);
        }
        Map<Account, Integer> countMap = new HashMap<>();
        for (Entry<String, Match> entry : matchs.entrySet()) {
            entry.getValue().getInfo().getParticipants().forEach(participant -> {
                countMap.merge(participant.getAccount(), 1, Integer::sum);
            });
        }
        countMap.entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> {
            data.getNodes().add(new JSNode(e.getKey().getRiotId()));
            data.getEdges().add(new JSEdge(account.getRiotId(), e.getKey().getRiotId()));
            recursivFriendDetection(e.getKey(), depth - 1, data);
        });
    }
}