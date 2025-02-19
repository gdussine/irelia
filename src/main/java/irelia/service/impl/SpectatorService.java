package irelia.service.impl;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.SpectatorAPI;
import irelia.data.spectator.CurrentGameInfo;
import irelia.data.spectator.FeaturedGames;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class SpectatorService extends RateLimitedRiotService implements SpectatorAPI{

	private final static String BY_PUUID_URI = "lol/spectator/v5/active-games/by-summoner/%s";
	private final static String FEATURED_GAMES_URI = "lol/spectator/v5/featured-games";


	public CompletableFuture<CurrentGameInfo> byPuuid(String puuid) {
		TypeReference<CurrentGameInfo> type = new TypeReference<CurrentGameInfo>() {
		};
		RiotRequest<CurrentGameInfo> request = this.createAPIRequest(type, irelia.getPlatform(), BY_PUUID_URI, puuid);
		return getAsync(request);
	}

	public CompletableFuture<FeaturedGames> featuredGames() {
		TypeReference<FeaturedGames> type = new TypeReference<FeaturedGames>() {
		};
		RiotRequest<FeaturedGames> request = this.createAPIRequest(type, irelia.getPlatform(), FEATURED_GAMES_URI);
		return getAsync(request);
	}


}
