package irelia.service.impl;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.data.spectator.CurrentGameInfo;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class SpectatorService extends RateLimitedRiotService {

	private final static String BY_PUUID_URI = "lol/spectator/v5/active-games/by-summoner/%s";

	public SpectatorService(Irelia riot) {
		super(riot);
	}

	public CompletableFuture<CurrentGameInfo> byPuuid(String puuid) {
		TypeReference<CurrentGameInfo> type = new TypeReference<CurrentGameInfo>() {
		};
		RiotRequest<CurrentGameInfo> request = this.createAPIRequest(type, irelia.getPlatform(), BY_PUUID_URI, puuid);
		return getAsync(request);
	}

}
