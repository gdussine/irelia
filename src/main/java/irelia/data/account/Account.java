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
		if(tab.length != 2 )
			throw new IllegalArgumentException("The Riot Id must include '#' to separate gameName and tagLine.");
		this.setGameName(tab[0]);
		this.setTagLine(tab[1]);
	}

	public void setGameName(String gameName) {
		if(gameName.length() < 3 || gameName.length() > 16) 
			throw new IllegalArgumentException("The gameName must be 3–16 alphanumeric characters long.");
		this.gameName = gameName;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		if(tagLine.length() < 3 || tagLine.length() > 5) 
			throw new IllegalArgumentException("The tagLine must be 3–5 alphanumeric characters long.");
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
