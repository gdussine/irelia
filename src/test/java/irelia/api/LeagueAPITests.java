package irelia.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import irelia.IreliaTests;
import irelia.data.account.Account;
import irelia.data.league.LeagueEntry;
import irelia.data.league.LeagueList;
import irelia.data.league.LeagueQueueType;
import irelia.data.league.LeagueRank;
import irelia.data.league.LeagueTier;
import irelia.data.summoner.Summoner;

@Tag("LeagueAPI")
public class LeagueAPITests extends IreliaTests {

    @ParameterizedTest
    @ValueSource(strings = { "Lukuu#EUW", "Guillaume#EUW", "Guillaume#TOP" })
    public void rankedPlayer(String riotId) {
        Account account = irelia.account().byRiotId(riotId).join();
        Summoner summoner = irelia.summoner().byPuuid(account.getPuuid()).join();
        Set<LeagueEntry> leagues = irelia.league().bySummoner(summoner.getId()).join();
        for (LeagueEntry league : leagues) {
            assertNotNull(league.getRank());
            assertNotNull(league.getTier());
        }
    }

    @Test
    public void apexLeagues() {
        LeagueList masterLeague = irelia.league().masterByQueue(LeagueQueueType.RANKED_SOLO_5x5).join();
        assertLeague(LeagueTier.MASTER, LeagueQueueType.RANKED_SOLO_5x5, masterLeague);
        LeagueList grandMasterLeague = irelia.league().grandmasterByQueue(LeagueQueueType.RANKED_SOLO_5x5).join();
        assertLeague(LeagueTier.GRANDMASTER,LeagueQueueType.RANKED_SOLO_5x5, grandMasterLeague);
        LeagueList challengerLeague = irelia.league().challengerByQueue(LeagueQueueType.RANKED_SOLO_5x5).join();
        assertLeague(LeagueTier.CHALLENGER, LeagueQueueType.RANKED_SOLO_5x5, challengerLeague);
        LeagueList masterLeague2 = irelia.league().byLeagueId(masterLeague.getLeagueId()).join();
        assertLeague(LeagueTier.MASTER, LeagueQueueType.RANKED_SOLO_5x5, masterLeague2);
        Set<LeagueEntry> gold3Leagues = irelia.league().byQueue(LeagueQueueType.RANKED_SOLO_5x5, LeagueTier.GOLD, LeagueRank.III, 5).join();
        for(LeagueEntry gold3League : gold3Leagues){
            assertLeague(LeagueTier.GOLD,LeagueQueueType.RANKED_SOLO_5x5,gold3League);
        }
    }

    private void assertLeague(LeagueTier expectedTier, LeagueQueueType expectedType, LeagueList league){
        assertEquals(expectedTier, league.getTier());
        assertEquals(expectedType, league.getQueue());
    }

    private void assertLeague(LeagueTier expectedTier, LeagueQueueType expectedType, LeagueEntry league){
        assertEquals(expectedTier, league.getTier());
        assertEquals(expectedType, league.getQueueType());
    }

}
