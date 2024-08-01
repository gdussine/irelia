package irelia.tools;

import irelia.data.account.Account;
import irelia.data.spectator.CurrentGameInfo;

public class Tracker extends LaunchableTool{
	
	@Override
	public void launch() {
		Thread trackerThread = new Thread(()->{
			Account acc = this.api.account().byRiotId("Guillaume", "TOP").join();
			CurrentGameInfo info = this.api.spectator().byPuuid(acc.getPuuid()).join();
			this.print(info);
		});
		trackerThread.start();
		try {
			trackerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
