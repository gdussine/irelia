package irelia.tools.lib;

import java.io.InputStream;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.tools.lib.SampleAccountProvider.SampleRiotId;
import irelia.tools.trackervz.TrackableAccount;
import irelia.tools.trackervz.Tracker;

public class Launcher {

	protected static Irelia irelia;

	private static Irelia startIrelia() {
		if (irelia == null) {
			try {
				InputStream in = Launcher.class.getClassLoader().getResourceAsStream("secrets.properties");
				Properties prop = new Properties();
				prop.load(in);
				irelia = new Irelia(prop.getProperty("apikey"), Platform.EUW1, Locale.FRENCH).start().join();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return irelia;
	}

	public static void stopIrelia() {
		irelia.stop();
	}


	public static void mainTracker2() {
		startIrelia();
		Tracker<TrackableAccount> tracker = new Tracker<>(irelia, Duration.ofSeconds(60), Duration.ofSeconds(60));
		SampleAccountProvider provider = new SampleAccountProvider(irelia);
		SampleRiotId[] accountIds = {SampleRiotId.INES10Z, SampleRiotId.BDG, SampleRiotId.REDDISH, SampleRiotId.BATMAN};
		provider.getAll().forEach(x-> tracker.register(new TrackableAccount(x)));
		tracker.start();
	}

	public static void main(String[] args) throws Exception {
		mainTracker2();
	}

}
