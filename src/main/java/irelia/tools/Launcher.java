package irelia.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import irelia.core.Irelia;
import irelia.core.Platform;

public class Launcher {

	protected static Irelia irelia;

	public static Irelia getIrelia() {
		if(irelia == null){
			try {
				InputStream in = Launcher.class.getClassLoader().getResourceAsStream("secrets.properties");
				Properties prop = new Properties();
				prop.load(in);
				irelia = new Irelia(prop.getProperty("apikey"), Platform.EUW1);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return irelia;
	}
	
	public static void main(String[] args) throws Exception {
		new Tracker().launch();
	}

}
