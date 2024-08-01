package irelia.core.service;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.request.RiotRequest;
import irelia.data.spectator.CurrentGameInfo;

public class SpectatorService extends RiotService{
	
	public SpectatorService(Irelia riot) {
		super(riot);
	}

	private final static String BY_PUUID_URI = "lol/spectator/v5/active-games/by-summoner/%s";
	
	public CompletableFuture<CurrentGameInfo> byPuuid(String puuid) {
		RiotRequest request = this.createAPIRequest(irelia.getPlatform(), BY_PUUID_URI, puuid);
		return getAsync(request, new TypeReference<CurrentGameInfo>() {});
	}

}
