package irelia.api;

import java.util.concurrent.CompletableFuture;

import irelia.data.spectator.CurrentGameInfo;

public interface SpectatorAPI {

    public CompletableFuture<CurrentGameInfo> byPuuid(String puuid);

}
