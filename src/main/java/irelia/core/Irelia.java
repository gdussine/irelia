package irelia.core;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.CompletionException;

import org.slf4j.Logger;

import irelia.api.RiotAPI;
import irelia.request.limit.RiotAppRateLimiter;
import irelia.request.limit.RiotRequestSender;
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

	private RiotAppRateLimiter appRateLimiter;
	private RiotRequestSender requestSender;

	private Logger log;

	public Irelia(String key, Platform platform, Locale locale) {
		super();
		this.key = key;
		this.platform = platform;
		this.region = platform.getRegion();
		this.locale = locale;
		this.requestSender = new RiotRequestSender(this);
		this.appRateLimiter = new RiotAppRateLimiter(this);
		this.log = IreliaLogger.CORE.logger(getClass());
		this.http = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();
		this.services = new RiotServices(this);
	}

	public void start() throws IreliaException {
		if (running) {
			this.log.warn("Irelia is already running.");
			return;
		}
		this.requestSender.start();
		this.appRateLimiter.start();
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
		this.appRateLimiter.stop();
		this.requestSender.stop();
		this.services.stop();
		this.http.shutdown();
		try {
			this.http.awaitTermination(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			this.http.shutdownNow();
		}
		this.log.info("Irelia stopped.");
		running = false;
	}

	public boolean isRunning() {
		return running;
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

	public RiotAppRateLimiter getAppRateLimiter() {
		return appRateLimiter;
	}

	public RiotRequestSender getRequestSender() {
		return requestSender;
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

	public MasteryService mastery(){
		return mastery();
	}

}
