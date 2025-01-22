package irelia.request.core;

public enum RiotRequestType {

	API("https://%s.api.riotgames.com/%s"), 
	DDRAGON("https://ddragon.leagueoflegends.com/%s"),

	RAWCOMMUNITY("https://raw.communitydragon.org/latest/%s"),	
	DEVELOPER("https://static.developer.riotgames.com/docs/lol/%s");

	private String base;

	private RiotRequestType(String base) {
		this.base = base;
	}

	public String url(String platform, String uri) {
		if (this.equals(API))
			return base.formatted(platform, uri);
		else
			return base.formatted(uri);
	}

	public boolean isOfficial(){
		if(this.equals(RAWCOMMUNITY))
			return false;
		return true;
	}

}
