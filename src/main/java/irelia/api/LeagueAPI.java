package irelia.api;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import irelia.data.league.LeagueEntry;
import irelia.data.league.LeagueList;
import irelia.data.league.LeagueQueueType;
import irelia.data.league.LeagueRank;
import irelia.data.league.LeagueTier;

public interface LeagueAPI {

    public CompletableFuture<List<LeagueEntry>> byPuuid(String puuid);

    public CompletableFuture<LeagueEntry> soloQ(String puuid);

    public CompletableFuture<LeagueEntry> flexQ(String puuid);

    public CompletableFuture<LeagueList> challengerByQueue(LeagueQueueType queueType);

    public CompletableFuture<LeagueList> grandmasterByQueue(LeagueQueueType queueType);

    public CompletableFuture<LeagueList> masterByQueue(LeagueQueueType queueType);

    public CompletableFuture<LeagueList> byLeagueId(String leagueId);

    public CompletableFuture<List<LeagueEntry>> byQueue(LeagueQueueType queueType, LeagueTier tier, LeagueRank division,
            int page);

}
