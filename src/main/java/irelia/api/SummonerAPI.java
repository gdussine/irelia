package irelia.api;

import java.util.concurrent.CompletableFuture;

import irelia.data.summoner.Summoner;

public interface SummonerAPI {

    public CompletableFuture<Summoner> byPuuid(String puuid);

}
