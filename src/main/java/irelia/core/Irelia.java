package irelia.core;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import irelia.core.request.limit.RiotAppRateLimiter;
import irelia.core.request.limit.RiotRequestSender;
import irelia.core.service.AccountService;
import irelia.core.service.DDragonService;
import irelia.core.service.LeagueService;
import irelia.core.service.SpectatorService;
import irelia.core.service.SummonerService;

public class Irelia {

	private String key;

	private Region region;
	private Platform platform;
	private Locale locale;
	private HttpClient http;

	private AccountService account;
	private DDragonService ddragon;
	private LeagueService league;
	private SpectatorService spectator;
	private SummonerService summoner;

	private RiotAppRateLimiter appRateLimiter;
	private RiotRequestSender requestSender;

	private Logger log;

	public Irelia(String key, Platform platform) {
		super();
		this.key = key;
		this.platform = platform;
		this.region = platform.getRegion();
		this.locale = Locale.FRANCE;
		this.requestSender = new RiotRequestSender(this);
		this.appRateLimiter = new RiotAppRateLimiter(this);
		this.log = LoggerFactory.getLogger(getClass());
		http = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();
		account = new AccountService(this);
		ddragon = new DDragonService(this);
		league = new LeagueService(this);
		spectator = new SpectatorService(this);
		summoner = new SummonerService(this);

	}

	public Irelia start() {
		this.requestSender.start();
		this.appRateLimiter.start();
		this.log.info("Started !");
		return this;
	}

	public void stop() {
		this.appRateLimiter.stop();
		this.requestSender.stop();
		this.account.stop();
		this.ddragon.stop();
		this.league.stop();
		this.spectator.stop();
		this.summoner.stop();
		this.log.info("Stopped !");
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

}
