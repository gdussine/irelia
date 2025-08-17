package irelia.api;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import irelia.IreliaTests;
import irelia.data.champion.ChampionRotation;

@Tag("APITest")
public class ChampionAPITests extends IreliaTests{

    @Test
    public void rotations(){
        ChampionRotation rotations = irelia.champion().rotations().join();
        assertNotNull(rotations);
        assertNotEquals(0, rotations.getMaxNewPlayerLevel());
        assertNotEquals(0,rotations.getFreeChampionIds().size());
        assertNotEquals(0,rotations.getFreeChampionIdsForNewPlayers().size());
    }

    @Test
    public void rotationRateLimite(){
        List<CompletableFuture<ChampionRotation>> futures = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            futures.add(irelia.champion().rotations());
        }

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.join();
        futures.forEach(f -> assertNotNull(f));
        
    }

}
