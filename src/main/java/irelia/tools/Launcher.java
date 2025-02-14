package irelia.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.function.Consumer;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.Platform;
import irelia.data.account.Account;
import irelia.data.community.QueueTypes;
import irelia.data.match.Match;
import irelia.data.match.MatchQuery;
import irelia.data.match.Participant;
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

	public static void launch(Consumer<Irelia> consumer){
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
		launch(irelia ->{
			MatchQuery query = new MatchQuery().setQueue(QueueTypes.QUEUE_RANKED_FLEX_440).setStart(1).setCount(15);
			Account account = irelia.account().byRiotId("Guillaume#TOP").join();
			List<String> matchIds = irelia.match().byPuuid(account.getPuuid(), query).join();
			for(String matchId : matchIds){
				Match match = irelia.match().byId(matchId).join();
				Participant participant = match.getInfo().getParticipants().stream().filter(x->x.getPuuid().equals(account.getPuuid())).findAny().orElse(null);
				System.out.println("------> " + matchId);
				System.out.println(participant.getRiotIdGameName());
				System.out.println(participant.getChampionName());
				System.out.println("%d/%d/%d".formatted(participant.getKills(), participant.getAssists(), participant.getDeaths()));
			} 
		});
	}

}
