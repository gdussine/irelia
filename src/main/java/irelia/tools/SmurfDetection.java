package irelia.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.match.Match;
import irelia.data.summoner.Summoner;

public class SmurfDetection {

    private Irelia irelia;
    private final static int NB_DAY = 7;

    public SmurfDetection(Irelia irelia){
        this.irelia = irelia;
    }

    public void matchAnalyze(Account account, int depth){
        
    }

    public void detect(Account account, ){
        System.out.println("Smurf detection");
        Summoner summoner = irelia.summoner().byPuuid(account.getPuuid()).join();
        System.out.println("Level detection : %d%%".formatted(Math.max(130-summoner.getSummonerLevel(),0)));
        List<String> ids = irelia.match().byPuuid(account.getPuuid(), (System.currentTimeMillis() - 1000 * 3600 * 24 * NB_DAY)/1000, System.currentTimeMillis()/1000).join();
        Map<String, Match> matchs = new HashMap<>();
        
        // Chargement des matchs des 7 derniers jours
        for(String id : ids){
            Match match = irelia.match().byId(id).join(); 
            matchs.put(match.getMetadata().getMatchId(), match);
        }

        // Chargement des matchs des 
        Map<String, Integer> countMap = new HashMap<>();
        for(Entry<String, Match> entry : matchs.entrySet()){
            entry.getValue().getMetadata().getParticipants().forEach(puuid ->{
                countMap.merge(puuid, 1, Integer::sum);
            });;
        }

        for(Entry<String, Integer> entry : countMap.entrySet()){
            if(entry.getValue() <1)
                continue;
            if(entry.getKey().equals(account.getPuuid()))
                continue;
            
        }

        countMap.forEach((k,v) ->{
            if(v > 1)
                System.out.println(k +": " + v);
        });


    }
    
}