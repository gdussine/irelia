package irelia.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import irelia.IreliaExtension;
import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.ddragon.Champions;
import irelia.data.mastery.ChampionMastery;

@ExtendWith(IreliaExtension.class)
public class MasteryAPITests {

    @ParameterizedTest
    @ValueSource(strings = { "LaMaliceMaxHehe#Heheh", "Guillaume#EUW", "Guillaume#TOP" })
    public void masteries(String riotId, Irelia irelia){
        Account account = irelia.account().byRiotId(riotId).join();
        List<ChampionMastery> masteries = irelia.mastery().byPuuid(account.getPuuid()).join();
        assertNotEquals(0, masteries.size());
    }

    @Test
    public void millionOnIrelia( Irelia irelia){
        Account owner = irelia.account().byRiotId("Guillaume#TOP").join();
        ChampionMastery mastery = irelia.mastery().byChampion(owner.getPuuid(), Champions.Irelia.getKey()).join(); 
        assertTrue(mastery.getChampionPoints() > 2000000L); 
    }

    @Test
    public void top3Guillaume( Irelia irelia){
        Account owner = irelia.account().byRiotId("Guillaume#TOP").join();
        List<ChampionMastery> masteries = irelia.mastery().top(owner.getPuuid()).join();
        assertEquals(3, masteries.size());
        assertEquals( Champions.Irelia.getKey(), masteries.get(0).getChampionId());
        assertEquals( Champions.Riven.getKey(), masteries.get(1).getChampionId());
        assertEquals( Champions.Yasuo.getKey(), masteries.get(2).getChampionId());
    }

    @Test
    public void top7Guillaume( Irelia irelia){
        Account owner = irelia.account().byRiotId("Guillaume#TOP").join();
        List<ChampionMastery> masteries = irelia.mastery().top(owner.getPuuid(), 7).join();
        assertEquals(7, masteries.size());
    }

    @Test
    public void scoreGuillaume( Irelia irelia){
        Account owner = irelia.account().byRiotId("Guillaume#TOP").join();
        int score = irelia.mastery().score(owner.getPuuid()).join();
        assertTrue(400< score);
    }

}
