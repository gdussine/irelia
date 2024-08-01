package irelia.core.service;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.request.RiotRequest;
import irelia.data.summoner.Summoner;

public class SummonerService extends RiotService{
	
	public SummonerService(Irelia riot) {
		super(riot);
	}

	private final static String BY_PUUID_URI = "lol/summoner/v4/summoners/by-puuid/%s";
	
	public CompletableFuture<Summoner> byPuuid(String puuid) {
		RiotRequest request = this.createAPIRequest(irelia.getPlatform(), BY_PUUID_URI, puuid);
		return getAsync(request, new TypeReference<Summoner>() {});
	}

}
