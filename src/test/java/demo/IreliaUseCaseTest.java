package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.tools.Launcher;

public class IreliaUseCaseTest {
	
	private Irelia irelia; 
	
	@Test
	public void getAccount(){
		this.irelia = Launcher.getIrelia();
		Account acc =this.irelia.account().byRiotId("Guillaume", "TOP").join();
		assertEquals(acc.getGameName(), "Guillaume");
		assertEquals(acc.getTagLine(), "TOP");
		assertNotNull(acc.getPuuid());
	}

}
