package irelia.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import irelia.IreliaExtension;
import irelia.core.Irelia;
import irelia.data.champion.ChampionRotation;

@Tag("APITest")
@ExtendWith(IreliaExtension.class)
public class ChampionAPITests {

    @Test
    public void rotations(Irelia irelia){
        ChampionRotation rotations = irelia.champion().rotations().join();
        assertNotNull(rotations);
        assertEquals(11, rotations.getMaxNewPlayerLevel());
        assertNotEquals(0,rotations.getNewplayer().size());
        assertNotEquals(0,rotations.getSr().size());
    }

    @Test
    public void rotationRateLimite(Irelia irelia){
        List<CompletableFuture<ChampionRotation>> futures = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            futures.add(irelia.champion().rotations());
        }
        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.join();
        futures.forEach(f -> assertNotNull(f));
        
    }

}
