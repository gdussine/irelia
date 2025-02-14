package irelia.api;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import irelia.IreliaTests;
import irelia.data.spectator.CurrentGameInfo;
import irelia.data.spectator.FeaturedGameInfo;
import irelia.data.spectator.FeaturedGameParticipant;
import irelia.data.spectator.FeaturedGames;

public class SpectatorAPITests extends IreliaTests {

    @Test
    public void featuredGames() {

        FeaturedGames games = irelia.spectator().featuredGames().join();
        assertNotNull(games);
        assertNotEquals(0, games.getGameList());
        for (FeaturedGameInfo featured : games.getGameList()) {
            assertNotNull(featured);
            assertNotNull(featured.getObservers());
            assertNotNull(featured.getObservers().getEncryptionKey());
            assertNotEquals("", featured.getObservers().getEncryptionKey());
            assertNotNull(featured.getParticipants());
            assertNotEquals(0, featured.getParticipants().size());
        }
        FeaturedGameParticipant first = games.getGameList().getFirst().getParticipants().getFirst();
        CurrentGameInfo current = irelia.spectator().byPuuid(first.getPuuid()).join();
        assertNotNull(current);
        assertNotNull(current.getObservers());
        assertNotEquals("", current.getObservers().getEncryptionKey());
        assertNotNull(current.getParticipants());
        assertNotEquals(0, current.getParticipants().size());
    }

}
