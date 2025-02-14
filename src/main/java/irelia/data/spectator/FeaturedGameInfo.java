package irelia.data.spectator;

import java.util.List;

import irelia.data.community.QueueTypes;

public class FeaturedGameInfo {
	
	private long gameId, mapId, gameLength, gameQueueConfigId;
	private String gameType, platformId, gameMode;
	private SpectatorObserver observers;
	private List<BannedChampion> bannedChampions;
	private List<FeaturedGameParticipant> participants;
	
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public long getMapId() {
		return mapId;
	}
	public void setMapId(long mapId) {
		this.mapId = mapId;
	}
	public long getGameLength() {
		return gameLength;
	}
	public void setGameLength(long gameLength) {
		this.gameLength = gameLength;
	}
	public long getGameQueueConfigId() {
		return gameQueueConfigId;
	}

	public QueueTypes getQueueType(){
		return QueueTypes.from(gameQueueConfigId);
	}

	public void setGameQueueConfigId(long gameQueueConfigId) {
		this.gameQueueConfigId = gameQueueConfigId;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public SpectatorObserver getObservers() {
		return observers;
	}
	public void setObservers(SpectatorObserver observers) {
		this.observers = observers;
	}
	public List<BannedChampion> getBannedChampions() {
		return bannedChampions;
	}
	public void setBannedChampions(List<BannedChampion> bannedChampions) {
		this.bannedChampions = bannedChampions;
	}
	public List<FeaturedGameParticipant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<FeaturedGameParticipant> participants) {
		this.participants = participants;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (gameId ^ (gameId >>> 32));
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
		FeaturedGameInfo other = (FeaturedGameInfo) obj;
		if (gameId != other.gameId)
			return false;
		return true;
	}

	
	
	

}
