package irelia.data.ddragon;

import java.util.List;
import java.util.Map;

public class ChampionInfo {
	private String version;
	private String id;
	private String key;
	private String name;
	private String title;
	private String blurb;
	private Map<String, Integer> info;
	private ImageInfo image;
	private List<String> tags;
	private String partype;
	private Map<String, Double> stats;
	
	public ChampionInfo() {
		super();
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}
	public Map<String, Integer> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Integer> info) {
		this.info = info;
	}
	public ImageInfo getImage() {
		return image;
	}
	public void setImage(ImageInfo image) {
		this.image = image;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getPartype() {
		return partype;
	}
	public void setPartype(String partype) {
		this.partype = partype;
	}
	public Map<String, Double> getStats() {
		return stats;
	}
	public void setStats(Map<String, Double> stats) {
		this.stats = stats;
	}
	
	

}
