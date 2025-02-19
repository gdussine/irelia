package irelia.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.MatchAPI;
import irelia.data.match.Match;
import irelia.data.match.MatchQuery;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class MatchServices extends  RateLimitedRiotService implements MatchAPI{


	private final static String BY_PUUID_URI = "lol/match/v5/matches/by-puuid/%s/ids";
	private final static String BY_ID_URI = "lol/match/v5/matches/%s";
	
	public CompletableFuture<List<String>> byPuuid(String puuid) {
		TypeReference<List<String>> type = new TypeReference<List<String>>() {};
		RiotRequest<List<String>> request = this.createAPIRequest(type, irelia.getRegion(), BY_PUUID_URI, puuid);
		return getAsync(request);
	}

	public CompletableFuture<List<String>> byPuuid(String puuid, long startTime, long endTime){
		return this.byPuuid(puuid, new MatchQuery().setStartTime(startTime).setEndTime(endTime));
	}

	public CompletableFuture<List<String>> byPuuid(String puuid, int start, int count) {
		return this.byPuuid(puuid, new MatchQuery().setStart(start).setCount(count));
	}

	public CompletableFuture<Match> byId(String id){
		TypeReference<Match> type = new TypeReference<Match>() {};
		RiotRequest<Match> request = this.createAPIRequest(type, irelia.getRegion(), BY_ID_URI, id);
		return getAsync(request);
	}

	@Override
	public CompletableFuture<List<String>> byPuuid(String puuid, MatchQuery query) {
		TypeReference<List<String>> type = new TypeReference<List<String>>() {};
		RiotRequest<List<String>> request = this.createAPIRequest(type, irelia.getRegion(), BY_PUUID_URI+query.getQueryString(), puuid);
		return getAsync(request);
	}

}
