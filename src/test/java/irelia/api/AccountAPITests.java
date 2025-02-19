package irelia.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.concurrent.CompletionException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import irelia.IreliaTests;
import irelia.core.IreliaException;
import irelia.data.account.Account;
import irelia.request.core.RiotRequestException;

public class AccountAPITests extends IreliaTests {

    @ParameterizedTest
    @ValueSource(strings = { "Guillaume#TOP"})
    public void existingAccount(String riotId) throws IreliaException {
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
    public void riotIdMissingHash(String riotId) {
        assertThrowsExactly(IllegalArgumentException.class, () -> irelia.account().byRiotId(riotId));
    }

    @ParameterizedTest
    @ValueSource(strings = {"TheGameNameIsVeryVeryVeryLong#TEST", "Name#TagTooLong"})
    public void riotIdTooLong(String riotId){
        String[] accountInfo = riotId.split("#");
        assertThrowsExactly(IllegalArgumentException.class,() -> irelia.account().byRiotId(accountInfo[0],accountInfo[1]));
    }

    @ParameterizedTest
    @ValueSource (strings = {"Guillaume#EUW9"})
    public void nonExistingAccount(String riotId){
        CompletionException ce = assertThrowsExactly(CompletionException.class, () -> irelia.account().byRiotId(riotId).join());
        assertInstanceOf(RiotRequestException.class, ce.getCause());
        RiotRequestException re = (RiotRequestException) ce.getCause();
        assertEquals(404, re.getStatus().getCode());
    }

    private void checkAccount(Account account, String gameName, String tagLine) {
        assertNotNull(account);
        assertNotNull(account.getPuuid());
        assertEquals(gameName + "#" + tagLine, account.getRiotId());
        assertEquals(gameName, account.getGameName());
        assertEquals(tagLine, account.getTagLine());
    }

}
