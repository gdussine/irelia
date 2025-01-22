package irelia.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;

import irelia.core.Irelia;
import irelia.data.community.QueueInfo;
import irelia.data.ddragon.ChampionInfo;

public class IreliaEnumBuilder {

    private final String OUTPUT_PATH = "src/main/java/irelia/data/%s/%s.java";
    private final String INPUT_PATH = "src/main/resources/template/%s.tmpl";
    private Irelia irelia;

    public IreliaEnumBuilder(Irelia irelia) {
        this.irelia = irelia;
    }

    public <T> void build(String serviceName, String name, Class<T> type, Supplier<Map<String, T>> supplier,
            Function<Entry<String, T>, String> converter)
            throws Exception {
        File inputFile = new File(INPUT_PATH.formatted(name));
        InputStream in = new FileInputStream(inputFile);
        String template = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        File outputFile = new File(OUTPUT_PATH.formatted(serviceName, name));
        FileWriter writer = new FileWriter(outputFile);
        boolean isFirstLine = true;
        StringBuilder sb = new StringBuilder();
        for (Entry<String, T> entry : supplier.get().entrySet()) {
            if (!isFirstLine)
                sb.append(",");
            sb.append(converter.apply(entry));
            isFirstLine = false;
        }
        sb.append(";");
        writer.append(template.formatted(sb.toString()));
        writer.close();
    }

    public void buildChampions() throws Exception {
        build("ddragon", "Champions", ChampionInfo.class,
                () -> irelia.ddragon().getDDragon().join().getChampions(),
                x -> "\n\t%s(%s,\"%s\")".formatted(x.getKey(), x.getValue().getKey(), x.getValue().getName()));
    }

    public void buildQueueTypes() throws Exception {
        build("community", "QueueTypes", QueueInfo.class,
                () -> {
                    Map<String, QueueInfo> map = new HashMap<>();
                    irelia.community().queue().join().stream().forEach(x -> {
                        if (x.getName().equals("Custom") || x.getGameSelectPriority() > 0) {
                            String key = "QUEUE_%s_%d".formatted(
                                    x.getShortName().replace(" ", "_").replaceAll("[/\\(\\)/]", "").toUpperCase(),
                                    x.getId());
                            map.put(key, x);
                        }
                    });
                    return map;
                },
                x -> "\n\t%s(%d,\"%s\")".formatted(x.getKey(), x.getValue().getId(), x.getValue().getName()));
    }
}
