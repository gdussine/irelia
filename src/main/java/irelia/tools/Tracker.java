package irelia.tools;

import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.league.LeagueEntry;
import irelia.data.summoner.Summoner;

public class Tracker extends LaunchableTool {

	@Override
	public void launch() {
		Irelia irelia = Launcher.getIrelia();
		Account acc = irelia.account().byRiotId("Guillaume", "TOP").join();
		Summoner sum = irelia.summoner().byPuuid(acc.getPuuid()).join();
		LeagueEntry soloq = irelia.league().solo(sum.getId()).join();
		System.out.println(soloq);
		irelia.stop();
	}

}
