package irelia.service.impl;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.SummonerAPI;
import irelia.data.summoner.Summoner;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class SummonerService extends RateLimitedRiotService implements SummonerAPI {

	private final static String BY_PUUID_URI = "lol/summoner/v4/summoners/by-puuid/%s";
	


	private TypeReference<Summoner> type = new TypeReference<Summoner>() {};


	@Override
	public CompletableFuture<Summoner> byPuuid(String puuid) {
		RiotRequest<Summoner> request = this.createAPIRequest(type, irelia.getPlatform(), BY_PUUID_URI, puuid);
		return getAsync(request);
	}
}
