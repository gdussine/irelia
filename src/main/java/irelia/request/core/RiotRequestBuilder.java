package irelia.request.core;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.core.Region;

public class RiotRequestBuilder<T> {

	protected final static String API_TOKEN_HEADER = "X-Riot-Token";
	protected final static String API_HTTP_BASE = "https://%s.api.riotgames.com/%s";
	protected final static String DDRAGON_HTTP_BASE = "https://ddragon.leagueoflegends.com/%s";

	private String uri;
	private String platform;
	private RiotRequestType requestType;
	private Irelia riot;
	private TypeReference<T> type;
	private String endpoint;

	public RiotRequestBuilder(Irelia riot, TypeReference<T> type) {
		this.riot = riot;
		this.type = type;
	}

	public RiotRequestBuilder<T> setRequestType(RiotRequestType requestType) {
		this.requestType = requestType;
		return this;
	}

	public RiotRequestBuilder<T> setURI(String uri, Object... args) {
		this.endpoint = uri;
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

	public RiotRequestBuilder<T> setPlatform(Region region) {
		this.platform = region.name().toLowerCase();
		return this;
	}

	public RiotRequestBuilder<T> setPlatform(Platform platform) {
		this.platform = platform.name().toLowerCase();
		return this;
	}

	public RiotRequest<T> build() {
		switch (requestType) {
		case API:
			URI apiURI = URI.create(API_HTTP_BASE.formatted(platform, this.uri));
			return new RiotRequest<T>(
					HttpRequest.newBuilder().GET().header(API_TOKEN_HEADER, riot.getKey()).uri(apiURI).build(), type,
					endpoint);
		case DDRAGON:
		default:
			URI ddragonURI = URI.create(DDRAGON_HTTP_BASE.formatted(this.uri));
			return new RiotRequest<T>(HttpRequest.newBuilder().GET().uri(ddragonURI).build(), type, endpoint);
		}
	}

}
