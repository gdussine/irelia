package irelia.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import irelia.IreliaExtension;
import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.data.account.Account;

@Tag("APITest")
@ExtendWith(IreliaExtension.class)
public class AccountAPITests {

    @ParameterizedTest
    @ValueSource(strings = { "Guillaume#TOP"})
    public void existingAccount(String riotId, Irelia irelia) throws IreliaException {
        String[] accountInfo = riotId.split("#");
        Account account = irelia.account().byRiotId(riotId).join();
        checkAccount(account, accountInfo[0], accountInfo[1]);
        Account account2 = irelia.account().byRiotId(accountInfo[0], accountInfo[1]).join();
        checkAccount(account2, accountInfo[0], accountInfo[1]);
        assertEquals(account, account2);
        Account account3 = irelia.account().byPuuid(account.getPuuid()).join();
        checkAccount(account3, accountInfo[0], accountInfo[1]);
        assertNotNull(account);
    }

    @ParameterizedTest
    @ValueSource(strings = { "TestNoTag", "#TAG", "GameName#"})
    public void riotIdMissingHash(String riotId, Irelia irelia) {
        assertThrowsExactly(IllegalArgumentException.class, () -> irelia.account().byRiotId(riotId));
    }

    @ParameterizedTest
    @ValueSource(strings = {"TheGameNameIsVeryVeryVeryLong#TEST", "Name#TagTooLong"})
    public void riotIdTooLong(String riotId, Irelia irelia){
        String[] accountInfo = riotId.split("#");
        assertThrowsExactly(IllegalArgumentException.class,() -> irelia.account().byRiotId(accountInfo[0],accountInfo[1]));
    }

    @ParameterizedTest
    @ValueSource (strings = {"Guillaume#EUW9"})
    public void nonExistingAccount(String riotId, Irelia irelia){
        Account account = irelia.account().byRiotId(riotId).join();
        assertNull(account);
    }

    private void checkAccount(Account account, String gameName, String tagLine) {
        assertNotNull(account);
        assertNotNull(account.getPuuid());
        assertEquals(gameName + "#" + tagLine, account.getRiotId());
        assertEquals(gameName, account.getGameName());
        assertEquals(tagLine, account.getTagLine());
    }

}
