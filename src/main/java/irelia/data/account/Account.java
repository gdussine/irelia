package irelia.data.account;

public class Account {

	private String puuid;
	private String gameName;
	private String tagLine;

	public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	public String getGameName() {
		return gameName;
	}

	public String getRiotId(){
		return gameName + "#" + tagLine ;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
	
	@Override
	public String toString() {
		return getRiotId();
	}

}
