package irelia.api;

import java.util.concurrent.CompletableFuture;

import irelia.data.summoner.Summoner;

public interface SummonerAPI {

    public CompletableFuture<Summoner> byPuuid(String puuid);

    public CompletableFuture<Summoner> byAccount(String accountId);

    public CompletableFuture<Summoner> BySummoner(String summonerId);

}
