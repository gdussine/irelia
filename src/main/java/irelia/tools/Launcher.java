package irelia.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Properties;
import java.util.function.Consumer;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.Platform;
import irelia.data.ddragon.Champions;
import irelia.tools.lib.SampleAccountProvider;
import irelia.tools.lib.SampleAccountProvider.SampleRiotId;

public class Launcher {

	protected static Irelia irelia;

	public static String getKeyFromProperties() {
		InputStream in = Launcher.class.getClassLoader().getResourceAsStream("secrets.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			return prop.getProperty("apikey");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void mainTracker2() {
		String key = getKeyFromProperties();
		Irelia irelia = new Irelia(key, Platform.EUW1, Locale.FRANCE);
		try {
			irelia.start();
		} catch (IreliaException e) {
			e.printStackTrace();
		}
		SampleAccountProvider provider = new SampleAccountProvider(irelia);
		SampleRiotId[] accountIds = { SampleRiotId.INES10Z, SampleRiotId.BDG, SampleRiotId.REDDISH,
				SampleRiotId.BATMAN };
		System.out.println(provider.getList(accountIds));
	}

	public static void launch(Consumer<Irelia> consumer) {
		Irelia irelia = new Irelia(getKeyFromProperties(), Platform.EUW1, Locale.ENGLISH);
		try {
			irelia.start();
			consumer.accept(irelia);
			irelia.stop();
		} catch (IreliaException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		launch(irelia -> {
			try {
				File targetFile = new File("output/img.png");
				OutputStream outStream = new FileOutputStream(targetFile);
				InputStream in = irelia.ddragon().getChampionSplash(Champions.MonkeyKing, 6).join();
				outStream.write(in.readAllBytes());
				outStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
