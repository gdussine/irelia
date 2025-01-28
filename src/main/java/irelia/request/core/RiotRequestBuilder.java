package irelia.request.core;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.core.Region;

public class RiotRequestBuilder<T> {

	protected final static String API_TOKEN_HEADER = "X-Riot-Token";

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
			encodedArgs[i] = URLEncoder.encode(args[i].toString(), StandardCharsets.UTF_8).replace("+", "%20");
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
		URI urlString = URI.create(requestType.url(platform, this.uri));
		HttpRequest.Builder request = HttpRequest.newBuilder().GET().uri(urlString).timeout(Duration.ofSeconds(5));
		if(requestType.equals(RiotRequestType.API))
			request.header(API_TOKEN_HEADER, riot.getKey());
		return new RiotRequest<T>(request.build(), requestType, type, endpoint);
	}
}
