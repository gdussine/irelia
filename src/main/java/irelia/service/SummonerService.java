package irelia.service;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.data.summoner.Summoner;
import irelia.request.core.RiotRequest;

public class SummonerService extends RiotService{
	
	public SummonerService(Irelia riot) {
		super(riot);
	}

	private final static String BY_PUUID_URI = "lol/summoner/v4/summoners/by-puuid/%s";
	
	public CompletableFuture<Summoner> byPuuid(String puuid) {
		TypeReference<Summoner> type = new TypeReference<Summoner>() {};
		RiotRequest<Summoner> request = this.createAPIRequest(type, irelia.getPlatform(), BY_PUUID_URI, puuid);
		return getAsync(request);
	}

}
