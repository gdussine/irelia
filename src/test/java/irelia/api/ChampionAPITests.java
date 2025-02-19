package irelia.api;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import irelia.IreliaTests;
import irelia.data.champion.ChampionRotation;

@Tag("ChampionAPI")
public class ChampionAPITests extends IreliaTests{

    @Test
    public void rotations(){
        ChampionRotation rotations = irelia.champion().rotations().join();
        assertNotNull(rotations);
        assertNotEquals(0, rotations.getMaxNewPlayerLevel());
        assertNotEquals(0,rotations.getFreeChampionIds().size());
        assertNotEquals(0,rotations.getFreeChampionIdsForNewPlayers().size());
    }

}
