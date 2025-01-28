package irelia.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;
import irelia.request.core.RiotRequest;
import irelia.request.core.RiotRequestBuilder;
import irelia.request.core.RiotRequestException;
import irelia.request.core.RiotRequestStatus;
import irelia.request.core.RiotRequestStatusObject;
import irelia.request.core.RiotRequestType;
import irelia.request.limit.RiotRequestManager;

public class RiotService {

	protected Irelia irelia;
	protected ObjectMapper mapper;
	protected Logger log;

	public RiotService(Irelia irelia) {
		this.irelia = irelia;
		this.mapper = new ObjectMapper();
		this.log = LoggerFactory.getLogger(this.getClass());
	}

	protected synchronized RiotRequestManager getRateLimiter(String endpoint) {
		return this.irelia.getRequestSender();
	}

	public void stop() {

	}

	protected <T> RiotRequest<T> createDDragonRequest(TypeReference<T> type, String uri, Object... args) {
		return new RiotRequestBuilder<T>(irelia, type).setRequestType(RiotRequestType.DDRAGON).setURI(uri, args)
				.build();
	}

	protected <T> RiotRequest<T> createRawCommunityRequest(TypeReference<T> type, String uri, Object... args) {
		return this.createRawCommunityRequest(type, uri, "default", args);
	}

	protected <T> RiotRequest<T> createRawCommunityRequest(TypeReference<T> type, String uri, String lang,
			Object... args) {
		return new RiotRequestBuilder<T>(irelia, type).setRequestType(RiotRequestType.RAWCOMMUNITY)
				.setURI(uri, lang, args)
				.build();
	}

	protected synchronized CompletableFuture<InputStream> getInputStreamAsync(RiotRequest<?> request) {
		CompletableFuture<InputStream> result = new CompletableFuture<InputStream>();
		this.getRateLimiter(request.getEndpoint()).submit(request).handleAsync((respons, t) -> {
			try {
				if (t != null)
					throw new Exception(t);
				this.log.debug(
						"Respons received in %s ms".formatted(System.currentTimeMillis() - request.getStartTime()));
				if (respons.statusCode() / 100 != 2 && request.getRequestType().isOfficial()) {
					throw new RiotRequestException(request,
							mapper.readValue(respons.body(), RiotRequestStatusObject.class).getStatus());
				} else if (respons.statusCode() / 100 != 2)
					throw new RiotRequestException(request,
							new RiotRequestStatus("External API Provider Exception", respons.statusCode()));
				result.complete(new ByteArrayInputStream(respons.body()));
			} catch (Exception e) {
				result.completeExceptionally(e);
			}
			return respons;
		});
		return result;
	}

	protected <T> CompletableFuture<T> getAsync(RiotRequest<T> request) {
		this.logRequest(request);
		CompletableFuture<T> result = new CompletableFuture<>();
		CompletableFuture<InputStream> futureInput = this.getInputStreamAsync(request);
		futureInput.handle((in, ex) -> {
			if (ex != null) {
				return result.completeExceptionally(ex);
			}
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
