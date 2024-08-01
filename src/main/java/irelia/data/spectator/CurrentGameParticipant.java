package irelia.data.spectator;

import java.util.List;

public class CurrentGameParticipant {
	
	private long championId, profileIconId, teamId, spell1Id, spell2Id;
	private boolean bot;
	private String summonerId, puuid, riotId;
	private Perks perks;
	private List<GameCustomizationObject> gameCustomizationObjects;
	
	public long getChampionId() {
		return championId;
	}
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	public long getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(long profileIconId) {
		this.profileIconId = profileIconId;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public long getSpell1Id() {
		return spell1Id;
	}
	public void setSpell1Id(long spell1Id) {
		this.spell1Id = spell1Id;
	}
	public long getSpell2Id() {
		return spell2Id;
	}
	public void setSpell2Id(long spell2Id) {
		this.spell2Id = spell2Id;
	}
	public boolean isBot() {
		return bot;
	}
	public void setBot(boolean bot) {
		this.bot = bot;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	public String getPuuid() {
		return puuid;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public Perks getPerks() {
		return perks;
	}
	public void setPerks(Perks perks) {
		this.perks = perks;
		
	}
	public String getRiotId() {
		return riotId;
	}
	public void setRiotId(String riotId) {
		this.riotId = riotId;
	}
	public List<GameCustomizationObject> getGameCustomizationObjects() {
		return gameCustomizationObjects;
	}
	public void setGameCustomizationObjects(List<GameCustomizationObject> gameCustomizationObjects) {
		this.gameCustomizationObjects = gameCustomizationObjects;
	}
	
	
	
	

}
