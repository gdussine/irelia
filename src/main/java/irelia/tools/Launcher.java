package irelia.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.function.Consumer;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.Platform;
import irelia.data.account.Account;
import irelia.data.ddragon.Champions;
import irelia.data.ddragon.DDragon;
import irelia.data.match.Match;
import irelia.data.match.MatchQuery;
import irelia.data.match.Participant;
import irelia.data.match.MatchQuery.Type;
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

	public static void main(String[] args) throws Exception {
		launch(irelia -> {
			try {
				Account account = irelia.account().byRiotId("Guillaume#TOP").join();
				MatchQuery query = new MatchQuery().setCount(6).setStart(10).setType(Type.normal);
				String matchId = irelia.match().byPuuid(account.getPuuid(), query).join().get(5);
				Match match = irelia.match().byId(matchId).join();
				Participant p = match.getInfo().getParticipants().get(0);
				DDragon dragon = irelia.ddragon().getDDragon().join();
				System.out.println(dragon.getItem(p.getItem0()).getName()
						+ " - " + p.getItem1()
						+ " - " + p.getItem2()
						+ " - " + p.getItem3()
						+ " - " + p.getItem4()
						+ " - " + p.getItem5()
						+ " - " + p.getItem6());
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
