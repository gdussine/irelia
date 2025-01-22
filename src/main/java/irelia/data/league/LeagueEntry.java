package irelia.data.league;

public class LeagueEntry {

	private String leagueId, summonerId;
	private LeagueRank rank;
	private LeagueTier tier;
	private LeagueQueueType queueType;
	private int leaguePoints, wins, losses;
	private boolean hotStreak, veteran, freshBlood, inactive;
	private MiniSeries miniSeries;

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public LeagueQueueType getQueueType() {
		return queueType;
	}

	public void setQueueType(LeagueQueueType queueType) {
		this.queueType = queueType;
	}

	public LeagueRank getRank() {
		return rank;
	}

	public void setRank(LeagueRank rank) {
		this.rank = rank;
	}

	public LeagueTier getTier() {
		return tier;
	}

	public void setTier(LeagueTier tier) {
		this.tier = tier;
	}

	public int getLeaguePoints() {
		return leaguePoints;
	}

	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public boolean isHotStreak() {
		return hotStreak;
	}

	public void setHotStreak(boolean hotStreak) {
		this.hotStreak = hotStreak;
	}

	public boolean isVeteran() {
		return veteran;
	}

	public void setVeteran(boolean veteran) {
		this.veteran = veteran;
	}

	public boolean isFreshBlood() {
		return freshBlood;
	}

	public void setFreshBlood(boolean freshBlood) {
		this.freshBlood = freshBlood;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}

	public MiniSeries getMiniSeries() {
		return miniSeries;
	}

	public void setMiniSeries(MiniSeries miniSeries) {
		this.miniSeries = miniSeries;
	}

	public int getElo(){
		return this.getTier().getEloOffset() + this.getRank().getEloOffset() + this.leaguePoints;
	}

	@Override
	public String toString() {
		return queueType + ":" + tier + "-" + rank + "-" + leaguePoints + "lp";
	}

}
