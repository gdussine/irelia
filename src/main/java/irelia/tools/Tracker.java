package irelia.tools;

import irelia.core.Irelia;

public class Tracker extends LaunchableTool {

	@Override
	public void launch() {
		Irelia irelia = Launcher.getIrelia().start();
		int count = 105;
		Thread[] ts = new Thread[count];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new Thread(() -> {

				System.out.println(irelia.account().byRiotId("Guillaume", "TOP").join());
			});
		}
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
		}
		for (int i = 0; i < ts.length; i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		irelia.stop();
	}

}
