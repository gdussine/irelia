package irelia.api;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import irelia.IreliaExtension;
import irelia.core.Irelia;
import irelia.data.champion.ChampionRotation;
import irelia.request.core.RiotRequest;

@Tag("APITest")
@ExtendWith(IreliaExtension.class)
public class ChampionAPITests {

    @Test
    public void rotations(Irelia irelia){
        ChampionRotation rotations = irelia.champion().rotations().join();
        assertNotNull(rotations);
        assertNotEquals(0,rotations.newplayer().size());
        assertNotEquals(0,rotations.sr().size());
    }

    @Test
    public void object(Irelia irelia){
        ChampionRotation rotations = irelia.champion().rotations().join();
        RiotRequest<byte[]> request = new RiotRequest<>(null, null, null, null);
    }
}
