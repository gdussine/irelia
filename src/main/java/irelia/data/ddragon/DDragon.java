package irelia.data.ddragon;

import java.util.Map;

public class DDragon {

	private String version;
	private String lang;
	private Map<String, ChampionInfo> champions;
	private Map<String, IconInfo> icons;
	private Map<String, ItemInfo> items;

	public DDragon() {

	}

	public DDragon(String version, String lang, Map<String, ChampionInfo> champions, Map<String, IconInfo> icons, Map<String, ItemInfo> items) {
		super();
		this.version = version;
		this.lang = lang;
		this.champions = champions;
		this.icons = icons;
		this.items = items;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Map<String, ChampionInfo> getChampions() {
		return champions;
	}

	public void setChampions(Map<String, ChampionInfo> champions) {
		this.champions = champions;
	}
	
	public ChampionInfo getChampion(Champions champion) {
		return champions.get(champion.name());
	}

	public IconInfo getIcon(Integer id){
		return icons.get(id.toString());
	}

	public void setIcons(Map<String, IconInfo> icons) {
		this.icons = icons;
	}

	public ItemInfo getItem(Integer id) {
		return items.get(id.toString());
	}

	public void setItems(Map<String, ItemInfo> items) {
		this.items = items;
	}




}
