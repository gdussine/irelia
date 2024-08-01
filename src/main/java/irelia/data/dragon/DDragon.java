package irelia.data.dragon;

import java.util.Map;

public class DDragon {

	private String version;
	private String lang;
	private Map<String, ChampionInfo> champions;
	private Map<String, IconInfo> icons;

	public DDragon() {

	}

	public DDragon(String version, String lang, Map<String, ChampionInfo> champions, Map<String, IconInfo> icons) {
		super();
		this.version = version;
		this.lang = lang;
		this.champions = champions;
		this.icons = icons;
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
	
	public ChampionInfo getChampion(Champions champions) {
		return this.champions.get(champions.name());
	}

	public Map<String, IconInfo> getIcons() {
		return icons;
	}

	public void setIcons(Map<String, IconInfo> icons) {
		this.icons = icons;
	}

}
