package irelia.api;

import java.util.concurrent.CompletableFuture;

import irelia.data.champion.ChampionRotation;

/**
 * 
 * Interface for Riot Champion API
 * @version     3
 * 
 **/
public interface ChampionAPI {

        public CompletableFuture<ChampionRotation> rotations();

}
