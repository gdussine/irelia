package irelia.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import irelia.IreliaExtension;
import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.league.LeagueEntry;
import irelia.data.league.LeagueItem;
import irelia.data.league.LeagueList;
import irelia.data.league.LeagueQueueType;
import irelia.data.league.LeagueRank;
import irelia.data.league.LeagueTier;
import irelia.data.summoner.Summoner;

@Tag("APITest")
@ExtendWith(IreliaExtension.class)
public class LeagueAPITests {

    @ParameterizedTest
    @ValueSource(strings = { "LaMaliceMaxHehe#Heheh", "Guillaume#EUW", "Guillaume#TOP" })
    public void rankedPlayer( String riotId, Irelia irelia) {
        Account account = irelia.account().byRiotId(riotId).join();
        Summoner summoner = irelia.summoner().byPuuid(account.getPuuid()).join();
        List<LeagueEntry> leagues = irelia.league().byPuuid(summoner.getPuuid()).join();
        int counter = 0;
        LeagueEntry teamQ = irelia.league().teamQ(summoner.getPuuid()).join();
        counter += (teamQ == null ? 0 : 1);
        LeagueEntry soloQ = irelia.league().soloQ(summoner.getPuuid()).join();
        counter += (soloQ == null ? 0 : 1);
        LeagueEntry flexQ = irelia.league().flexQ(summoner.getPuuid()).join();
        counter += (flexQ == null ? 0 : 1);
        assertLeagueObject(leagues);
        assertEquals(counter, leagues.size());
    }

    @Test
    public void masterLeague(Irelia irelia) {
        LeagueList masterLeague = irelia.league().masterByQueue(LeagueQueueType.RANKED_SOLO_5x5).join();
        assertLeagueObject(masterLeague);
        assertLeague(LeagueTier.MASTER, LeagueQueueType.RANKED_SOLO_5x5, masterLeague);
    }

    @Test
    public void challengerLeague(Irelia irelia) {
        LeagueList league = irelia.league().challengerByQueue(LeagueQueueType.RANKED_SOLO_5x5).join();
        assertLeagueObject(league);
        assertLeague(LeagueTier.CHALLENGER, LeagueQueueType.RANKED_SOLO_5x5, league);
    }

    @Test
    public void grandMasterLeague(Irelia irelia) {
        LeagueList league = irelia.league().grandmasterByQueue(LeagueQueueType.RANKED_SOLO_5x5).join();
        assertLeagueObject(league);
        assertLeague(LeagueTier.GRANDMASTER, LeagueQueueType.RANKED_SOLO_5x5, league);
    }

    @Test
    public void gold3League(Irelia irelia) {
        List<LeagueEntry> gold3Leagues = irelia.league()
                .byQueue(LeagueQueueType.RANKED_SOLO_5x5, LeagueTier.GOLD, LeagueRank.III, 2).join();
        assertLeagueObject(gold3Leagues);
        for (LeagueEntry gold3League : gold3Leagues) {
            assertLeague(LeagueTier.GOLD, LeagueQueueType.RANKED_SOLO_5x5, gold3League);
        }
    }

    private void assertLeague(LeagueTier expectedTier, LeagueQueueType expectedType, LeagueList league) {
        assertEquals(expectedTier, league.getTier());
        assertEquals(expectedType, league.getQueue());
    }

    private void assertLeagueObject(List<LeagueEntry> leagues) {
        for (LeagueEntry league : leagues) {
            assertNotNull(league.getRank());
            assertNotNull(league.getTier());
            assertNotNull(league.getQueueType());
            assertNotNull(league.getLeaguePoints());
            assertNotNull(league.getWins());
            assertNotNull(league.getLosses());
            assertNotNull(league.isHotStreak());
            assertNotNull(league.isVeteran());
            assertNotNull(league.isFreshBlood());
            assertNotNull(league.isFreshBlood());
            assertNotNull(league.isInactive());
        }
    }

    private void assertLeagueObject(LeagueList leagueList) {
        for (LeagueItem league : leagueList.getEntries()) {
            assertNotNull(league.getRank());
            assertNotNull(leagueList.getTier());
            assertNotNull(leagueList.getQueue());
            assertNotNull(league.getLeaguePoints());
            assertNotNull(league.getWins());
            assertNotNull(league.getLosses());
            assertNotNull(league.isHotStreak());
            assertNotNull(league.isVeteran());
            assertNotNull(league.isFreshBlood());
            assertNotNull(league.isFreshBlood());
            assertNotNull(league.isInactive());
        }
    }

    private void assertLeague(LeagueTier expectedTier, LeagueQueueType expectedType, LeagueEntry league) {

        assertEquals(expectedTier, league.getTier());
        assertEquals(expectedType, league.getQueueType());
    }

}
