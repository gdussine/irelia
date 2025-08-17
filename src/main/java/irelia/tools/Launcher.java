package irelia.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.function.Consumer;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.Platform;

public class Launcher {

	protected Irelia irelia;

	public String getKeyFromProperties() {
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

	public Irelia startIrelia(String apiKey, Platform platform, Locale locale) {
		if (irelia != null)
			return irelia;
		irelia = new Irelia(getKeyFromProperties(), platform, locale);
		try {
			irelia.start();
			return irelia;
		} catch (IreliaException e) {
			e.printStackTrace();
			return null;
		}
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
}