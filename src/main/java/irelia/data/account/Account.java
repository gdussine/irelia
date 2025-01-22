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

	public void setRiotId(String riotId){
		String[] tab = riotId.split("#");
		this.gameName = tab[0];
		this.tagLine = tab[1];
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((puuid == null) ? 0 : puuid.hashCode());
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
		Account other = (Account) obj;
		if (puuid == null) {
			if (other.puuid != null)
				return false;
		} else if (!puuid.equals(other.puuid))
			return false;
		return true;
	}

	

}
