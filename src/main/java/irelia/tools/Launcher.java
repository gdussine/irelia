package irelia.tools;

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.data.community.QueueTypes;
import irelia.tools.tracker.Tracker;

public class Launcher {

	protected static Irelia irelia;

	public static Irelia startIrelia() {
		if(irelia == null){
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

	public static void stopIrelia(){
		irelia.stop();
	}

	public static void mainTracker(){
		startIrelia();
		Tracker tracker = new Tracker(irelia, 300, 120, QueueTypes.from(420), QueueTypes.from(440));
		SampleAccountProvider provider = new SampleAccountProvider(irelia);
		tracker.registerAll(provider.getSamples());
		tracker.start();
	}

	public static void mainBuilder() throws Exception{
		startIrelia();
		irelia.changeLocale(Locale.ENGLISH).join();
		IreliaEnumBuilder enumBuilder = new IreliaEnumBuilder(irelia);
		enumBuilder.buildQueueTypes();
		enumBuilder.buildChampions();
		stopIrelia();
	}
	
	public static void main(String[] args) throws Exception {
		Thread.sleep(10000);
		startIrelia();
		Thread.sleep(10000);
		irelia.account().byRiotId("Guillaume#TOP");
		Thread.sleep(10000);
		irelia.account().byRiotId("Adry#metal");
		Thread.sleep(10000);
		stopIrelia();
		Thread.sleep(3000);
	}

}
