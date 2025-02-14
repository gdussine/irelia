package irelia.api;

import java.util.concurrent.CompletableFuture;

import irelia.data.spectator.CurrentGameInfo;
import irelia.data.spectator.FeaturedGames;

public interface SpectatorAPI {

    public CompletableFuture<CurrentGameInfo> byPuuid(String puuid);

    public CompletableFuture<FeaturedGames> featuredGames();

}
