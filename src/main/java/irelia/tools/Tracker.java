package irelia.tools;

import irelia.core.Irelia;
import irelia.data.account.Account;

public class Tracker extends LaunchableTool {

	@Override
	public void launch() {
		Irelia irelia = Launcher.startIrelia();
		Account acc = irelia.account().byRiotId("Guillaume", "TOP").join();
		SmurfDetection smurf = new SmurfDetection(irelia);
		smurf.detect(acc);
		Launcher.stopIrelia();
	}

}
