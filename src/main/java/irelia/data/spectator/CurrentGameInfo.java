package irelia.data.spectator;

import java.util.List;

import irelia.data.community.QueueTypes;

public class CurrentGameInfo {
	
	private long gameId, gameStartTime, mapId, gameLength, gameQueueConfigId;
	private String gameType, platformId, gameMode;
	private SpectatorObserver observers;
	private List<BannedChampion> bannedChampions;
	private List<CurrentGameParticipant> participants;
	
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public long getGameStartTime() {
		return gameStartTime;
	}
	public void setGameStartTime(long gameStartTime) {
		this.gameStartTime = gameStartTime;
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
	public List<CurrentGameParticipant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<CurrentGameParticipant> participants) {
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
		CurrentGameInfo other = (CurrentGameInfo) obj;
		if (gameId != other.gameId)
			return false;
		return true;
	}

	
	
	

}
