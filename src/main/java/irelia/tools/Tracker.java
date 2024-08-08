package irelia.tools;

import java.io.InputStream;

import irelia.data.account.Account;
import irelia.data.dragon.IconInfo;
import irelia.data.spectator.CurrentGameInfo;
import irelia.data.summoner.Summoner;

public class Tracker extends LaunchableTool{
	
	@Override
	public void launch() {
		Thread trackerThread = new Thread(()->{
			Account acc = this.api.account().byRiotId("Batman", "feur").join();
			Summoner sum = this.api.summoner().byPuuid(acc.getPuuid()).join();
			IconInfo ico = this.api.ddragon().getDDragon().join().getIcons().get(sum.getProfileIconId()+"");
			InputStream in = this.api.ddragon().getProfileIcon(ico.getImage().getFull()).join();
			System.out.println(in);
			//CurrentGameInfo info = this.api.spectator().byPuuid(acc.getPuuid()).join();
			//this.print(info);
		});
		trackerThread.start();
		try {
			trackerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
