package irelia.api;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import irelia.data.league.LeagueEntry;
import irelia.data.league.LeagueList;
import irelia.data.league.LeagueQueueType;
import irelia.data.league.LeagueRank;
import irelia.data.league.LeagueTier;

public interface LeagueAPI {

    public CompletableFuture<Set<LeagueEntry>> bySummoner(String summonerId);

    public CompletableFuture<LeagueList> challengerByQueue(LeagueQueueType queueType);

    public CompletableFuture<LeagueList> grandmasterByQueue(LeagueQueueType queueType);

    public CompletableFuture<LeagueList> masterByQueue(LeagueQueueType queueType);

    public CompletableFuture<LeagueList> byLeagueId(String leagueId);

    public CompletableFuture<Set<LeagueEntry>> byQueue(LeagueQueueType queueType, LeagueTier tier, LeagueRank division, int page);

}
