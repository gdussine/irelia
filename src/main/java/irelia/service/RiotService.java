package irelia.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.core.Region;
import irelia.data.status.StatusObject;
import irelia.request.core.RiotRequest;
import irelia.request.core.RiotRequestBuilder;
import irelia.request.core.RiotRequestException;
import irelia.request.core.RiotRequestType;
import irelia.request.limit.RiotMethodRateLimiter;

public class RiotService {

	protected Irelia irelia;
	protected ObjectMapper mapper;
	private Map<String, RiotMethodRateLimiter> rateLimiters;
	protected Logger log;

	public RiotService(Irelia irelia) {
		this.irelia = irelia;
		this.mapper = new ObjectMapper();
		this.log = LoggerFactory.getLogger(this.getClass());
		this.rateLimiters = new HashMap<>();
	}

	private synchronized RiotMethodRateLimiter getRateLimiter(String endpoint) {
		RiotMethodRateLimiter result = rateLimiters.get(endpoint);
		if (result == null) {
			result = new RiotMethodRateLimiter(irelia, endpoint);
			result.start();
			rateLimiters.put(endpoint, result);
		}
		return result;
	}

	public void stop() {
		for (Entry<String, RiotMethodRateLimiter> s : rateLimiters.entrySet()) {
			s.getValue().stop();
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

	protected <T> RiotRequest<T> createDDragonRequest(TypeReference<T> type, String uri, Object... args) {
		return new RiotRequestBuilder<T>(irelia, type).setRequestType(RiotRequestType.DDRAGON).setURI(uri, args)
				.build();
	}

	protected synchronized CompletableFuture<InputStream> getInputStreamAsync(RiotRequest<?> request) {
		CompletableFuture<InputStream> result = new CompletableFuture<InputStream>();
		this.getRateLimiter(request.getEndpoint()).submit(request).thenAcceptAsync(respons -> {
			this.log.debug("Respons received in %s ms".formatted(System.currentTimeMillis() - request.getStartTime()));
			try {
				if (respons.statusCode() / 100 != 2)
					throw new RiotRequestException(request,
							mapper.readValue(respons.body(), StatusObject.class).getStatus());
				result.complete(new ByteArrayInputStream(respons.body()));
			} catch (Exception e) {
				result.completeExceptionally(e);
			}
		});
		return result;
	}

	protected <T> CompletableFuture<T> getAsync(RiotRequest<T> request) {
		this.logRequest(request);
		CompletableFuture<T> result = new CompletableFuture<>();
		CompletableFuture<InputStream> futureInput = this.getInputStreamAsync(request);
		futureInput.handle((in, ex) -> {
			if (ex != null)
				return result.completeExceptionally(ex);
			try {
				T t = mapper.readValue(in, request.getType());
				return result.complete(t);
			} catch (Exception e) {
				return result.completeExceptionally(e);
			}
		});
		return result;
	}

	protected <T> void logRequest(RiotRequest<T> request) {
		this.log.debug("Request \"%s\" send, expect %s as result.".formatted(
				request.getRequest().uri(), request.getType().getType().getTypeName()));
	}

}
