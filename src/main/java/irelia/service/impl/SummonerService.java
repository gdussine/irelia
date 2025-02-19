package irelia.service.impl;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.SummonerAPI;
import irelia.data.summoner.Summoner;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class SummonerService extends RateLimitedRiotService implements SummonerAPI {

	private final static String BY_PUUID_URI = "lol/summoner/v4/summoners/by-puuid/%s";
	private final static String BY_ACCOUNT_URI = "lol/summoner/v4/summoners/by-account/%s";
	private final static String BY_SUMMONER_URI = "lol/summoner/v4/summoners/%s";


	private TypeReference<Summoner> type = new TypeReference<Summoner>() {};


	@Override
	public CompletableFuture<Summoner> byPuuid(String puuid) {
		RiotRequest<Summoner> request = this.createAPIRequest(type, irelia.getPlatform(), BY_PUUID_URI, puuid);
		return getAsync(request);
	}

	@Override
	public CompletableFuture<Summoner> byAccount(String accountId) {
		RiotRequest<Summoner> request = this.createAPIRequest(type, irelia.getPlatform(), BY_ACCOUNT_URI, accountId);
		return getAsync(request);
	}

	@Override
	public CompletableFuture<Summoner> BySummoner(String summonerId) {
		RiotRequest<Summoner> request = this.createAPIRequest(type, irelia.getPlatform(), BY_SUMMONER_URI, summonerId);
		return getAsync(request);
	}

}
