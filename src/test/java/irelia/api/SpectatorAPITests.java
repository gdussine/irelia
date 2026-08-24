package irelia.api;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import irelia.IreliaExtension;
import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.spectator.CurrentGameInfo;

@Tag("APITest")
@ExtendWith(IreliaExtension.class)
public class SpectatorAPITests {

    @ParameterizedTest
    @ValueSource(strings = {"Guillaume#TOP", "Soraka en Abaya#Heheh", "Brunehilde#Valky",})
    public void spectator(String riotId, Irelia irelia) {
        Account acc = irelia.account().byRiotId(riotId).join();
        CurrentGameInfo info = irelia.spectator().byPuuid(acc.getPuuid()).join();
        if(info == null)
            return;
        assertNotNull(info.getGameId());
        assertFalse(info.getParticipants().get(0).isBot());
    }

}
