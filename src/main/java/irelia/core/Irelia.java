package irelia.core;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.CompletionException;

import org.slf4j.Logger;

import irelia.api.RiotAPI;
import irelia.request.limit.v2.IreliaAppQueue;
import irelia.request.limit.v2.IreliaHttpQueue;
import irelia.request.limit.v2.IreliaQueueManager;
import irelia.service.RiotServices;
import irelia.service.impl.AccountService;
import irelia.service.impl.ChampionService;
import irelia.service.impl.CommunityService;
import irelia.service.impl.DDragonService;
import irelia.service.impl.LeagueService;
import irelia.service.impl.MasteryService;
import irelia.service.impl.MatchServices;
import irelia.service.impl.SpectatorService;
import irelia.service.impl.StatusService;
import irelia.service.impl.SummonerService;

public class Irelia implements RiotAPI {

	private String key;
	private boolean running = false;

	private Region region;
	private Platform platform;
	private Locale locale;
	private HttpClient http;

	private RiotServices services;

	private IreliaAppQueue appQueue;
	private IreliaHttpQueue httpQueue;

	private Logger log;
	private IreliaQueueManager queueManager;

	public Irelia(String key, Platform platform, Locale locale) {
		super();
		this.key = key;
		this.platform = platform;
		this.region = platform.getRegion();
		this.locale = locale;
		this.appQueue = new IreliaAppQueue(this);
		this.httpQueue = new IreliaHttpQueue(this);
		this.queueManager = new IreliaQueueManager();
		this.log = IreliaLogger.CORE.logger(getClass());
		this.http = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();
		this.services = new RiotServices(this);
	}

	public void start() throws IreliaException {
		if (running) {
			this.log.warn("Irelia is already running.");
			return;
		}
		this.queueManager.start(httpQueue);
		this.queueManager.start(appQueue);
		this.services.start();
		try {
			this.status().platformData().join();
			this.running = true;
			this.log.info("Irelia started.");
		} catch (CompletionException e) {
			throw IreliaException.failedStart(e);
		}
	}

	public void stop() throws IreliaException {
		if (!running) {
			this.log.warn("Irelia is not running.");
			return;
		}
		this.log.info("Irelia stopping.");
		this.services.stop();
		this.queueManager.stop();
		this.http.shutdown();
		try {
			if (!this.http.awaitTermination(Duration.ofSeconds(5)))
				this.http.shutdownNow();
		} catch (InterruptedException e) {
			this.http.shutdownNow();
		}
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public IreliaHttpQueue getHttpQueue() {
		return httpQueue;
	}

	public IreliaAppQueue getAppQueue() {
		return appQueue;
	}

	public IreliaQueueManager getQueueManager() {
		return queueManager;
	}

	public String getKey() {
		return key;
	}

	public Region getRegion() {
		return region;
	}

	public Platform getPlatform() {
		return platform;
	}

	public HttpClient getHttp() {
		return http;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getLang() {
		return locale.getLanguage() + "_" + locale.getCountry();
	}

	@Override
	public AccountService account() {
		return services.account();
	}

	public DDragonService ddragon() {
		return services.ddragon();
	}

	public LeagueService league() {
		return services.league();
	}

	@Override
	public SpectatorService spectator() {
		return services.spectator();
	}

	@Override
	public SummonerService summoner() {
		return services.summoner();
	}

	public MatchServices match() {
		return services.match();
	}

	@Override
	public StatusService status() {
		return services.status();
	}

	public CommunityService community() {
		return services.community();
	}

	@Override
	public ChampionService champion() {
		return services.champion();
	}

	public MasteryService mastery() {
		return mastery();
	}

}
