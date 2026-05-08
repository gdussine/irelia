package irelia.service;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.IreliaException;
import irelia.core.Platform;
import irelia.core.Region;
import irelia.request.core.RiotRequest;
import irelia.request.core.RiotRequestBuilder;
import irelia.request.core.RiotRequestType;
import irelia.request.limit.v2.IreliaMethodQueue;

public class RateLimitedRiotService extends RiotService {

	private Map<String, IreliaMethodQueue> methodQueues = new HashMap<>();

	public RateLimitedRiotService() {
	}

	@Override
	protected IreliaMethodQueue getIreliaQueue(String endpoint) {
		IreliaMethodQueue result = methodQueues.get(endpoint);
		if (result == null) {
			result = new IreliaMethodQueue(irelia, endpoint, this);
			this.irelia.getQueueManager().start(result);
			methodQueues.put(endpoint, result);
		}
		return result;

	}

	public void stop() throws IreliaException {
	}

	public void disconnectQueue(IreliaMethodQueue queue){
		methodQueues.remove(queue.getEndpoint());
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
