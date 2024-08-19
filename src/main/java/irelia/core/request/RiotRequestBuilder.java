package irelia.core.request;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.core.Region;

public class RiotRequestBuilder {

	protected final static String API_TOKEN_HEADER = "X-Riot-Token";
	protected final static String API_HTTP_BASE = "https://%s.api.riotgames.com/%s";
	protected final static String DDRAGON_HTTP_BASE = "https://ddragon.leagueoflegends.com/%s";

	private String uri;
	private String platform;
	private RiotRequestType requestType;
	private Irelia riot;

	public RiotRequestBuilder(Irelia riot) {
		this.riot = riot;
	}

	public RiotRequestBuilder setRequestType(RiotRequestType requestType) {
		this.requestType = requestType;
		return this;
	}

	public RiotRequestBuilder setURI(String uri, Object... args) {
		Object[] encodedArgs = new String[args.length];
		for (int i = 0; i < args.length; i++) {
			try {
				encodedArgs[i] = URLEncoder.encode(args[i].toString(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		this.uri = uri.formatted(encodedArgs);
		return this;
	}

	public RiotRequestBuilder setPlatform(Region region) {
		this.platform = region.name().toLowerCase();
		return this;
	}

	public RiotRequestBuilder setPlatform(Platform platform) {
		this.platform = platform.name().toLowerCase();
		return this;
	}

	public RiotRequest build() {
		switch (requestType) {
		case API:
			URI apiURI = URI.create(API_HTTP_BASE.formatted(platform, this.uri));
			return new RiotRequest(
					HttpRequest.newBuilder().GET().header(API_TOKEN_HEADER, riot.getKey()).uri(apiURI).build());
		case DDRAGON:
		default:
			URI ddragonURI = URI.create(DDRAGON_HTTP_BASE.formatted(this.uri));
			return new RiotRequest(HttpRequest.newBuilder().GET().uri(ddragonURI).build());
		}
	}

}
