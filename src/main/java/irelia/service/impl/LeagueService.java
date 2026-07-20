package irelia.service.impl;

import java.util.List;
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

	private final static String BY_PUUID_URI = "lol/league/v4/entries/by-puuid/%s";
	private final static String BY_QUEUE_URI = "lol/league-exp/v4/entries/%s/%s/%s";
	private final static String BY_LEAGUE_URI = "lol/league/v4/leagues/%s";
	private final static String APEX_BY_QUEUE = "lol/league/v4/%sleagues/by-queue/%s";

	@Override
	public CompletableFuture<List<LeagueEntry>> byPuuid(String puuid) {
		TypeReference<List<LeagueEntry>> type = new TypeReference<List<LeagueEntry>>() {
		};
		RiotRequest<List<LeagueEntry>> request = this.createAPIRequest(type, irelia.getPlatform(), BY_PUUID_URI, puuid);
		return getRiotObject(request);
	}

	public CompletableFuture<LeagueEntry> soloQ(String puuid) {
		return byPuuid(puuid).thenApply(list -> list.stream()
				.filter(e -> e.getQueueType().equals(LeagueQueueType.RANKED_SOLO_5x5)).findAny().orElse(null));
	}

	public CompletableFuture<LeagueEntry> flexQ(String puuid) {
		return byPuuid(puuid).thenApply(list -> list.stream()
				.filter(e -> e.getQueueType().equals(LeagueQueueType.RANKED_FLEX_SR)).findAny().orElse(null));
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
		RiotRequest<LeagueList> request = this.createAPIRequest(type, irelia.getPlatform(), APEX_BY_QUEUE,
				tier.name().toLowerCase(), queueType);
		return getRiotObject(request);

	}

	@Override
	public CompletableFuture<LeagueList> byLeagueId(String leagueId) {
		TypeReference<LeagueList> type = new TypeReference<LeagueList>() {
		};
		RiotRequest<LeagueList> request = this.createAPIRequest(type, irelia.getPlatform(), BY_LEAGUE_URI, leagueId);
		return getRiotObject(request);
	}

	@Override
	public CompletableFuture<List<LeagueEntry>> byQueue(LeagueQueueType queueType, LeagueTier tier, LeagueRank division,
			int page) {
		String param = "?start=%d".formatted(page);
		TypeReference<List<LeagueEntry>> type = new TypeReference<List<LeagueEntry>>() {
		};
		RiotRequest<List<LeagueEntry>> request = this.createAPIRequest(type, irelia.getPlatform(), BY_QUEUE_URI + param,
				queueType, tier, division);
		return getRiotObject(request);
	}

}
