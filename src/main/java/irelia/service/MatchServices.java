package irelia.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.data.match.Match;
import irelia.request.core.RiotRequest;

public class MatchServices extends RiotService{
	
	public MatchServices(Irelia riot) {
		super(riot);
	}

	private final static String BY_PUUID_URI = "lol/match/v5/matches/by-puuid/%s/ids";
	private final static String BY_ID_URI = "lol/match/v5/matches/%s";
	
	public CompletableFuture<List<String>> byPuuid(String puuid) {
		TypeReference<List<String>> type = new TypeReference<List<String>>() {};
		RiotRequest<List<String>> request = this.createAPIRequest(type, irelia.getRegion(), BY_PUUID_URI, puuid);
		return getAsync(request);
	}

	public CompletableFuture<List<String>> byPuuid(String puuid, long startTime, long endTime){
		String param = "?startTime=%d&endTime=%d".formatted(startTime, endTime);
		TypeReference<List<String>> type = new TypeReference<List<String>>() {};
		RiotRequest<List<String>> request = this.createAPIRequest(type, irelia.getRegion(), BY_PUUID_URI+param, puuid);
		return getAsync(request);
	}

	public CompletableFuture<List<String>> byPuuid(String puuid, int start, int count) {
		String param = "?start=%d&count=%d".formatted(start, count);
		TypeReference<List<String>> type = new TypeReference<List<String>>() {};
		RiotRequest<List<String>> request = this.createAPIRequest(type, irelia.getRegion(), BY_PUUID_URI+param, puuid);
		return getAsync(request);
	}

	public CompletableFuture<Match> byId(String id){
		TypeReference<Match> type = new TypeReference<Match>() {};
		RiotRequest<Match> request = this.createAPIRequest(type, irelia.getRegion(), BY_ID_URI, id);
		return getAsync(request);
	}

}
