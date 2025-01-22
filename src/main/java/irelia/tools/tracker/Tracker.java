package irelia.tools.tracker;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import irelia.core.Irelia;
import irelia.data.account.Account;
import irelia.data.community.QueueTypes;
import irelia.data.league.LeagueEntry;
import irelia.data.spectator.CurrentGameInfo;
import irelia.data.summoner.Summoner;
import irelia.tools.LaunchableTool;

public class Tracker extends LaunchableTool {

	private Irelia irelia;
	private List<TrackableAccount> trackedAfk = new ArrayList<>();
	private List<TrackableAccount> trackedInGame = new ArrayList<>();
	Thread threadAfk, threadInGame;
	private List<QueueTypes> queueTypes;
	private long periodInGame, periodAfk;
	private Logger log;

	public Tracker(Irelia irelia, long afkPeriod, long inGamePeriod, QueueTypes... queueTypes) {
		this.irelia = irelia;
		this.queueTypes = List.of(queueTypes);
		this.periodAfk = afkPeriod;
		this.periodInGame = inGamePeriod;
		this.log = LoggerFactory.getLogger(getClass());
		threadAfk = new Thread(() -> {
			try {
				this.afk();
			} catch (InterruptedException e) {
				log.error("AFK Thread interrupted", e);
			}
		});
		threadInGame = new Thread(() -> {
			try {
				this.inGame();
			} catch (InterruptedException e) {
				log.error("InGame Thread interrupted", e);
			}
		});
	}

	public void register(String gameName, String tagLine) {
		Account acc = irelia.account().byRiotId(gameName, tagLine).join();
		this.register(acc);
	}

	public void register(Account account){
		Summoner sum = irelia.summoner().byPuuid(account.getPuuid()).join();
		Set<LeagueEntry> leagues = irelia.league().leagues(sum.getId()).join();
		TrackableAccount trackableAccount = new TrackableAccount(account, sum, leagues);
		this.trackedAfk.add(trackableAccount);
	}

	public void registerAll(List<Account> accounts){
		accounts.forEach(x->this.register(x));
	}

	public synchronized void start() {
		// afkFuture = ex.scheduleAtFixedRate(() -> trackAfk(), 2, afkPeriod,
		// TimeUnit.SECONDS);
		// inGameFuture = ex.scheduleAtFixedRate(() -> trackInGame(), 2, inGamePeriod,
		// TimeUnit.SECONDS);
		threadAfk.start();
		threadInGame.start();
	}

	public void onJoinGame(TrackableAccount acc, CurrentGameInfo game) {
		System.out.println("%s JOIN GAME %s".formatted(acc.getAccount(), acc.getCurrentGame().getGameId()));
	}

	public void onEndGame(TrackableAccount acc, CurrentGameInfo game) {
		System.out.println("%s END GAME %s".formatted(acc.getAccount(), acc.getCurrentGame().getGameId()));
	}

	public void afk() throws InterruptedException {
		log.debug("AFK Thread started!");
		Duration period = Duration.ofSeconds(periodAfk);
		int i = 0;
		while (true) {
			Duration waitTime = period.dividedBy(Math.max(trackedAfk.size(), 1));
			Thread.sleep(waitTime);
			if (trackedAfk.size() == 0)
				continue;
			TrackableAccount account = trackedAfk.get(i);
			CurrentGameInfo info = irelia.spectator().byPuuid(account.getAccount().getPuuid())
					.exceptionally((t) -> null).join();
			if (info != null && queueTypes.contains(info.getQueueType())) {
				account.setCurrentGame(info);
				onJoinGame(account, info);
				trackedInGame.add(account);
				trackedAfk.remove(account);
				i = Math.max(i-1, 0);
			}
			System.out.println("AFK: %s - %s".formatted(account.getAccount(), info));
			i = i >= trackedAfk.size() - 1 ? 0 : i + 1;
		}
	}

	public void inGame() throws InterruptedException {
		log.debug("InGame Thread started!");
		Duration period = Duration.ofSeconds(periodInGame);
		int i = 0;
		while (true) {
			
			Duration waitTime = period.dividedBy(Math.max(trackedInGame.size(), 1));
			Thread.sleep(waitTime);
			if (trackedInGame.size() == 0){
				System.out.println("IGm: waiting..");	
				continue;
			}
			TrackableAccount account = trackedInGame.get(i);
			CurrentGameInfo info = irelia.spectator().byPuuid(account.getAccount().getPuuid())
					.exceptionally((t) -> null).join();
			if (info == null) {
				onEndGame(account, account.getCurrentGame());
				trackedAfk.add(account);
				trackedInGame.remove(account);
				i = Math.max(i-1, 0);
			} else if (queueTypes.contains(info.getQueueType())
					&& info.getGameId() != account.getCurrentGame().getGameId()) {
				onEndGame(account, account.getCurrentGame());
				account.setCurrentGame(info);
				onJoinGame(account, info);
			}
			System.out.println("IGm: %s - %s".formatted(account.getAccount(), info));
			i = i >= trackedInGame.size() - 1 ? 0 : i + 1;
		}
	}

}
