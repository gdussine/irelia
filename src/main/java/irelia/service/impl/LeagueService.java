package irelia.service.impl;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.LeagueAPI;
import irelia.data.league.LeagueEntry;
import irelia.data.league.LeagueList;
import irelia.data.league.LeagueQueueType;
import irelia.data.league.LeagueRank;
import irelia.data.league.LeagueTier;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class LeagueService extends RateLimitedRiotService implements LeagueAPI {

	private final static String BY_SUMMONER_URI = "lol/league/v4/entries/by-summoner/%s";
	private final static String BY_QUEUE_URI = "lol/league-exp/v4/entries/%s/%s/%s";
	private final static String BY_LEAGUE_URI = "lol/league/v4/leagues/%s";
	private final static String APEX_BY_QUEUE = "lol/league/v4/%sleagues/by-queue/%s";

	@Deprecated
	public CompletableFuture<Set<LeagueEntry>> leagues(String summonerId) {
		TypeReference<Set<LeagueEntry>> type = new TypeReference<Set<LeagueEntry>>() {
		};
		RiotRequest<Set<LeagueEntry>> request = this.createAPIRequest(type, irelia.getPlatform(), BY_SUMMONER_URI,
				summonerId);
		return getAsync(request);
	}

	private CompletableFuture<LeagueEntry> league(String ssummonerId, LeagueQueueType key) {
		CompletableFuture<LeagueEntry> result = new CompletableFuture<LeagueEntry>();
		leagues(ssummonerId).handle((set, t) -> {
			if (t != null)
				return result.completeExceptionally(t);
			return result.complete(set.stream().filter(x -> x.getQueueType().equals(key)).findFirst().orElse(null));
		});
		return result;
	}

	@Override
	public CompletableFuture<Set<LeagueEntry>> bySummoner(String summonerId) {
		TypeReference<Set<LeagueEntry>> type = new TypeReference<Set<LeagueEntry>>() {
		};
		RiotRequest<Set<LeagueEntry>> request = this.createAPIRequest(type, irelia.getPlatform(), BY_SUMMONER_URI,
				summonerId);
		return getAsync(request);
	}

	public CompletableFuture<LeagueEntry> solo(String summonerId) {
		return league(summonerId, LeagueQueueType.RANKED_SOLO_5x5);
	}

	public CompletableFuture<LeagueEntry> flex(String summonerId) {
		return league(summonerId, LeagueQueueType.RANKED_FLEX_SR);
	}

	@Override
	public CompletableFuture<LeagueList> challengerByQueue(LeagueQueueType queueType) {
		return apexByQueue(queueType, LeagueTier.CHALLENGER);
	}

	@Override
	public CompletableFuture<LeagueList> grandmasterByQueue(LeagueQueueType queueType) {
		return apexByQueue(queueType, LeagueTier.GRANDMASTER);
	}

	@Override
	public CompletableFuture<LeagueList> masterByQueue(LeagueQueueType queueType) {
		return apexByQueue(queueType, LeagueTier.MASTER);
	}

	public CompletableFuture<LeagueList> apexByQueue(LeagueQueueType queueType, LeagueTier tier) {
		TypeReference<LeagueList> type = new TypeReference<LeagueList>() {
		};
		RiotRequest<LeagueList> request = this.createAPIRequest(type, irelia.getPlatform(), APEX_BY_QUEUE, tier.name().toLowerCase(), queueType);
		return getAsync(request);

	}

	@Override
	public CompletableFuture<LeagueList> byLeagueId(String leagueId) {
		TypeReference<LeagueList> type = new TypeReference<LeagueList>() {};
		RiotRequest<LeagueList> request = this.createAPIRequest(type, irelia.getPlatform(), BY_LEAGUE_URI,leagueId);
		return getAsync(request);
		
	}

	@Override
	public CompletableFuture<Set<LeagueEntry>> byQueue(LeagueQueueType queueType, LeagueTier tier,LeagueRank division, int page) {
		String param = "?start=%d".formatted(page);
		TypeReference<Set<LeagueEntry>> type = new TypeReference<Set<LeagueEntry>>() {
		};
		RiotRequest<Set<LeagueEntry>> request = this.createAPIRequest(type, irelia.getPlatform(), BY_QUEUE_URI+param,
				queueType, tier, division);
		return getAsync(request);
	}

}
