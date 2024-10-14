package irelia.tools;

import java.util.Scanner;

import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.league.LeagueEntry;
import irelia.data.summoner.Summoner;

public class Tracker extends LaunchableTool {

	@Override
	public void launch() {
		Irelia irelia = Launcher.startIrelia();
		Scanner scan = new Scanner(System.in);
		System.out.print("> GameName: ");
		String gameName = scan.nextLine();
		System.out.print("> TagLine: ");
		String tagLine = scan.nextLine();
		Account acc = irelia.account().byRiotId(gameName, tagLine).join();
		Summoner sum = irelia.summoner().byPuuid(acc.getPuuid()).join();
		LeagueEntry soloq = irelia.league().solo(sum.getId()).join();
		System.out.println(soloq + " -> " + soloq.getElo() +" elo");
		Launcher.stopIrelia();
	}

}
