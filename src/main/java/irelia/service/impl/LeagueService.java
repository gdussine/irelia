package irelia.service.impl;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.data.league.LeagueEntry;
import irelia.data.league.LeagueQueueType;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class LeagueService extends RateLimitedRiotService {

	public LeagueService(Irelia riot) {
		super(riot);
	}

	private final static String BY_SUMMONER_URI = "lol/league/v4/entries/by-summoner/%s";

	public CompletableFuture<Set<LeagueEntry>> leagues(String summonerId) {
		TypeReference<Set<LeagueEntry>> type = new TypeReference<Set<LeagueEntry>>() {};
		RiotRequest<Set<LeagueEntry>> request = this.createAPIRequest(type, irelia.getPlatform(), BY_SUMMONER_URI, summonerId);
		return getAsync(request);
	}

	private CompletableFuture<LeagueEntry> league(String ssummonerId, LeagueQueueType key){
		CompletableFuture<LeagueEntry> result = new CompletableFuture<LeagueEntry>();
		leagues(ssummonerId).handle((set, t) ->{
			if(t != null)
				return result.completeExceptionally(t);
			return result.complete(set.stream().filter(x->x.getQueueType().equals(key)).findFirst().orElse(null));	
		});
		return result;
	}

	public CompletableFuture<LeagueEntry> solo(String summonerId){
		return league(summonerId, LeagueQueueType.RANKED_SOLO_5x5);
	}

	public CompletableFuture<LeagueEntry> flex(String summonerId){
		return league(summonerId, LeagueQueueType.RANKED_FLEX_SR);
	}

}
