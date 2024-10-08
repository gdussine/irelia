package irelia.tools;

import java.io.File;
import java.io.FileWriter;
import java.util.Map.Entry;
import java.util.Set;

import irelia.data.dragon.ChampionInfo;
import irelia.data.dragon.DDragon;

public class ChampionsEnumBuilder extends LaunchableTool {

	public void launch() throws Exception {
		File javaFile = new File("src/main/java/irelia/data/dragon/Champions.java");
		FileWriter writer = new FileWriter(javaFile);
		writer.append("package irelia.data.dragon;\nimport java.util.Map;\nimport java.util.HashMap;\n");

		writer.append("public enum Champions{\n");
		DDragon ddragon = api.ddragon().getDDragon().join();
		Set<Entry<String, ChampionInfo>> entries = ddragon.getChampions().entrySet();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		for (Entry<String, ChampionInfo> entry : entries) {
			sb.append(
					"\t%s(%s,\"%s\")".formatted(entry.getKey(), entry.getValue().getKey(), entry.getValue().getName()));
			i++;
			sb.append(i == entries.size() ? ";" : ",").append("\n");
		}
		writer.append(sb.toString());
		writer.append("\tprivate int key;private String label;\n");
		writer.append("\tprivate static final Map<Integer, Champions> keyMap;\n");
		writer.append("\tstatic {keyMap = new HashMap<>();for (Champions c : values())keyMap.put(c.getKey(), c);}\n");
		
		writer.append("\tprivate Champions(int key, String label) {this.key = key;this.label = label;}\n");
		writer.append("\tpublic int getKey() {return key;}\n");
		writer.append("\tpublic String getLabel() {return label;}\n");
		writer.append("\tpublic static Champions getByKey(int key) {return keyMap.get(key);}\n");
		writer.append("\n}\n");
		writer.close();
	}

}
