package irelia.data.dragon;

import java.util.Map;

public class DDragonObject<T> {
	
	private String type;
	private String format;
	private String version;
	private Map<String, T> data;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Map<String, T> getData() {
		return data;
	}
	public void setData(Map<String, T> data) {
		this.data = data;
	}
	
	

}
