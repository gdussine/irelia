package irelia.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;
import irelia.core.IreliaLogger;
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

	public RiotService() {
		this.mapper = new ObjectMapper();
		this.log = IreliaLogger.SERVICE.logger(getClass());
	}

	protected synchronized RiotRequestManager getRateLimiter(String endpoint) {
		return this.irelia.getRequestSender();
	}

	public void setIrelia(Irelia irelia) {
		this.irelia = irelia;
	}

	public void start() {
		this.log.debug("{} started.", getClass().getSimpleName());
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
			long time = (System.currentTimeMillis() - request.getStartTime());
			try {
				if (t != null)
					throw new Exception(t);
				if (respons.statusCode() / 100 != 2 && request.getRequestType().isOfficial()) {
					throw new RiotRequestException(request,
							mapper.readValue(respons.body(), RiotRequestStatusObject.class).getStatus());
				} else if (respons.statusCode() / 100 != 2)
					throw new RiotRequestException(request,
							new RiotRequestStatus("External API Provider Exception", respons.statusCode()));
				this.log.trace("Request: {}, Respons: \"{} OK\" in {}ms.", request, respons.statusCode(), time);
				result.complete(new ByteArrayInputStream(respons.body()));
			} catch (Exception e) {
				this.log.debug("Request: {},Respons {} in {}ms.",request, e.getMessage(), time);
				result.completeExceptionally(e);
			}
			return respons;
		});
		return result;
	}

	protected <T> CompletableFuture<T> getAsync(RiotRequest<T> request) {
		CompletableFuture<T> result = new CompletableFuture<>();
		CompletableFuture<InputStream> futureInput = this.getInputStreamAsync(request);
		futureInput.handle((in, ex) -> {
			if (in == null) {
				return result.completeExceptionally(ex);
			}
			try {
				T t = mapper.readValue(in, request.getType());
				in.close();
				return result.complete(t);
			} catch (Exception e) {
				return result.completeExceptionally(e);
			}
		});
		return result;
	}

}
