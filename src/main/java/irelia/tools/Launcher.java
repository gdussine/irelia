package irelia.tools;

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.function.Consumer;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.Platform;
import irelia.data.account.Account;
import irelia.tools.lib.IreliaEnumBuilder;

public class Launcher implements AutoCloseable {

	protected Irelia irelia;

	public Launcher(String resourcePath, Platform platform, Locale locale){
		String key = getKeyFromProperties(resourcePath);
		this.irelia = new Irelia(key, platform, locale);
		irelia.start();
	}

	public Launcher(Platform platform, Locale locale){
		this("secrets.properties", platform, locale);
	}

	public String getKeyFromProperties(String resourcePath) {
		Properties prop = new Properties();
		try (InputStream in = Launcher.class.getClassLoader().getResourceAsStream(resourcePath)) {
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

	public Irelia getIrelia() {
		return irelia;
	}

	@Override
	public void close() throws Exception {
		getIrelia().stop();
	}



	public static void main(String[] args) throws InterruptedException {
		try(Launcher l = new Launcher(Platform.EUW1, Locale.US)){
			// IreliaEnumBuilder eb = new IreliaEnumBuilder(l.getIrelia());
			// eb.buildChampions();
			Account acc = l.getIrelia().account().byRiotId("Guillaume#TOP").join();
			System.out.println(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}