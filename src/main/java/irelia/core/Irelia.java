package irelia.core;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.util.Locale;

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

	public Irelia(String key, Platform platform) {
		super();
		this.key = key;
		this.platform = platform;
		this.region = platform.getRegion();
		this.locale = Locale.FRANCE;
		http = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();
		account = new AccountService(this);
		ddragon = new DDragonService(this);
		league = new LeagueService(this);
		spectator = new SpectatorService(this);
		summoner = new SummonerService(this);
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
