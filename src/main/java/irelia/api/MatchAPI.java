package irelia.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import irelia.data.match.Match;
import irelia.data.match.MatchQuery;

public interface MatchAPI {

    public CompletableFuture<List<String>> byPuuid(String puuid);

    public CompletableFuture<List<String>> byPuuid(String puuid, long startTime, long endTime);

    public CompletableFuture<List<String>> byPuuid(String puuid, int start, int count);

    public CompletableFuture<List<String>> byPuuid(String puuid, MatchQuery query);

    public CompletableFuture<Match> byId(String id);

}
