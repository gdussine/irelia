package irelia.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import irelia.IreliaExtension;
import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.summoner.Summoner;

@ExtendWith(IreliaExtension.class)
public class SummonerAPITests  {

    @ParameterizedTest
    @ValueSource(strings = { "LaMaliceMaxHehe#Heheh", "Guillaume#EUW", "Guillaume#TOP" })
    public void summoner(String riotId,  Irelia irelia) {
        Account account = irelia.account().byRiotId(riotId).join();
        Summoner summoner = irelia.summoner().byPuuid(account.getPuuid()).join();
        assertNotNull(summoner);
        assertNotNull(summoner.getProfileIconId());
        assertNotNull(summoner.getPuuid());
        assertNotNull(summoner.getRevisionDate());
        assertNotNull(summoner.getSummonerLevel());
    }

}
