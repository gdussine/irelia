package irelia.core;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import irelia.request.limit.RiotAppRateLimiter;
import irelia.request.limit.RiotRequestSender;
import irelia.service.AccountService;
import irelia.service.CommunityService;
import irelia.service.DDragonService;
import irelia.service.LeagueService;
import irelia.service.MatchServices;
import irelia.service.SpectatorService;
import irelia.service.StatusService;
import irelia.service.SummonerService;

public class Irelia {

	private String key;
	private boolean running = false;

	private Region region;
	private Platform platform;
	private Locale locale;
	private HttpClient http;

	private AccountService account;
	private DDragonService ddragon;
	private LeagueService league;
	private SpectatorService spectator;
	private SummonerService summoner;
	private MatchServices match;
	private StatusService status;
	private CommunityService community;

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
		this.log = LoggerFactory.getLogger(getClass());
		http = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();
		account = new AccountService(this);
		ddragon = new DDragonService(this);
		league = new LeagueService(this);
		spectator = new SpectatorService(this);
		summoner = new SummonerService(this);
		match = new MatchServices(this);
		status = new StatusService(this);
		community = new CommunityService(this);
	}

	public CompletableFuture<Irelia> start() {
		if (running) {
			this.log.warn("Irelia is already started.");
			return CompletableFuture.completedFuture(this);
		}
		this.requestSender.start();
		this.appRateLimiter.start();
		return this.status.platformData().handle((data, t) -> {
			if (t != null)
				this.log.error("Irelia can't start.", t);
			else
				this.log.info("Irelia started for %s.".formatted(this.getPlatform().name()));
			return data;
		}).thenCompose(data -> {
			return this.ddragon.getDDragon();
		}).thenApply(x -> {
			this.running = true;
			return this;
		});
	}

	public void stop() {
		if (!running) {
			this.log.warn("Irelia is not started.");
			return;
		}
		this.appRateLimiter.stop();
		this.requestSender.stop();
		this.account.stop();
		this.ddragon.stop();
		this.league.stop();
		this.spectator.stop();
		this.summoner.stop();
		this.match.stop();
		this.status.stop();
		this.community.stop();
		this.http.shutdown();
		try {
			this.http.awaitTermination(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			this.http.shutdownNow();
		}
		this.log.info("Irelia stopped.");
		running = false;
	}

	public CompletableFuture<Irelia> changeLocale(Locale locale){
		if(locale.getCountry() == null){
			this.log.warn("Irelia only accept Country");
			return CompletableFuture.completedFuture(this);
		}
		this.locale = locale;
		this.ddragon.clearCahche();
		return this.ddragon.getDDragon().thenApply(d ->{
			return this;
		});

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

	public AccountService account() {
		return account;
	}

	public DDragonService ddragon() {
		return ddragon;
	}

	public LeagueService league() {
		return league;
	}

	public SpectatorService spectator() {
		return spectator;
	}

	public SummonerService summoner() {
		return summoner;
	}

	public MatchServices match() {
		return match;
	}

	public StatusService status() {
		return status;
	}

	public CommunityService community() {
		return community;
	}

}
