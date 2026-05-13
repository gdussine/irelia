package irelia.tools;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.CompletionException;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.Platform;
import irelia.data.account.Account;
import irelia.tools.lib.IreliaEnumBuilder;

public class Launcher {

	protected Irelia irelia;

	public String getKeyFromProperties() {
		Properties prop = new Properties();
		try (InputStream in = Launcher.class.getClassLoader().getResourceAsStream("secrets.properties")) {
			prop.load(in);
		} catch (Exception e1) {
			throw IreliaException.keyNotFound(e1);
		}
		String key = prop.getProperty("apikey");
		if (!checkApiKey(key)) {
			throw IreliaException.keyIllegal();
		}
		return key;
	}

	public boolean checkApiKey(String apiKey) {
		if (apiKey == null)
			return false;
		if (apiKey.length() < 10)
			return false;
		if (!apiKey.startsWith("RGAPI"))
			return false;
		return true;
	}

	public Irelia startIrelia(String apiKey, Platform platform, Locale locale) {
		if (irelia != null)
			return irelia;
		irelia = new Irelia(apiKey, platform, locale);
		irelia.start();
		return irelia;
	}

	public void loop(String apiKey, Consumer<Irelia> consumer) {
		Irelia irelia = new Irelia(apiKey, Platform.EUW1, Locale.ENGLISH);
		try {
			irelia.start();
			try {
				consumer.accept(irelia);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				irelia.stop();
			}
		} catch (IreliaException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Launcher l = new Launcher();
		String key = l.getKeyFromProperties();
		Irelia irelia = l.startIrelia(key, Platform.EUW1, Locale.FRANCE);
		Thread.sleep(Duration.ofSeconds(3));
		irelia.account().byRiotId("Guillaume", "TOP").exceptionally(t -> null).join();
		irelia.stop();
	}
}