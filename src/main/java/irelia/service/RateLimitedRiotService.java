package irelia.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.Platform;
import irelia.core.Region;
import irelia.request.core.RiotRequest;
import irelia.request.core.RiotRequestBuilder;
import irelia.request.core.RiotRequestType;
import irelia.request.limit.RiotMethodRateLimiter;

public class RateLimitedRiotService extends RiotService{

	private Map<String, RiotMethodRateLimiter> rateLimiters;

	public RateLimitedRiotService() {
		this.rateLimiters = new HashMap<>();
	}

	protected synchronized RiotMethodRateLimiter getRateLimiter(String endpoint) {
		RiotMethodRateLimiter result = rateLimiters.get(endpoint);
		if (result == null) {
			result = new RiotMethodRateLimiter(irelia, endpoint);
			result.start();
			rateLimiters.put(endpoint, result);
		}
		return result;
	}

	public void stop() throws IreliaException {
		for (Entry<String, RiotMethodRateLimiter> s : rateLimiters.entrySet()) {
			try {
				s.getValue().stop();
			} catch (IreliaException e) {
				throw IreliaException.riotServiceFailedStop(this, e);
			}
		}
	}

	protected <T> RiotRequest<T> createAPIRequest(TypeReference<T> type, Region region, String uri, Object... args) {
		return new RiotRequestBuilder<T>(irelia, type).setRequestType(RiotRequestType.API).setPlatform(region)
				.setURI(uri, args).build();
	}

	protected <T> RiotRequest<T> createAPIRequest(TypeReference<T> type, Platform platform, String uri,
			Object... args) {
		return new RiotRequestBuilder<T>(irelia, type).setRequestType(RiotRequestType.API).setPlatform(platform)
				.setURI(uri, args).build();
	}
}
