package irelia.api;

import java.util.concurrent.CompletableFuture;

import irelia.data.account.Account;

public interface AccountAPI {

    public CompletableFuture<Account> byRiotId(String gameName, String tagLine);

    public CompletableFuture<Account> byRiotId(String riotId);

    public CompletableFuture<Account> byPuuid(String puuid);
}
