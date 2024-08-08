package irelia.core.service;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.request.RiotRequest;
import irelia.data.league.LeagueEntry;

public class LeagueService extends RiotService {

	public LeagueService(Irelia riot) {
		super(riot);
	}

	private final static String BY_SUMMONER_URI = "lol/league/v4/entries/by-summoner/%s";

	public CompletableFuture<Set<LeagueEntry>> bySummoner(String summonerId) {
		TypeReference<Set<LeagueEntry>> type = new TypeReference<Set<LeagueEntry>>() {};
		RiotRequest<Set<LeagueEntry>> request = this.createAPIRequest(type, irelia.getPlatform(), BY_SUMMONER_URI, summonerId);
		return getAsync(request);
	}

}
