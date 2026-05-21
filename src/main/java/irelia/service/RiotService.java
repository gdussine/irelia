package irelia.service;

import java.lang.module.ResolutionException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.slf4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.IreliaLogger;
import irelia.request.core.RiotRequest;
import irelia.request.core.RiotRequestBuilder;
import irelia.request.core.RiotRequestType;
import irelia.request.exceptions.RiotResponseException;
import irelia.request.queue.IreliaQueue;

public class RiotService {

	protected Irelia irelia;
	protected ObjectMapper mapper;
	protected Logger log;

	public RiotService() {
		this.mapper = new ObjectMapper();
		this.log = IreliaLogger.SERVICE.logger(getClass());
	}

	protected IreliaQueue getIreliaQueue(String endpoint) {
		return this.irelia.getHttpQueue();
	}

	public void setIrelia(Irelia irelia) {
		this.irelia = irelia;
	}

	public void start() {
		this.log.debug("{} started.", getClass().getSimpleName());
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

	public void stop() throws IreliaException {

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

	protected CompletableFuture<byte[]> getBytesAsync(RiotRequest<byte[]> request) {
		this.getIreliaQueue(request.getEndpoint()).put(request);
		return request.getFuture().handle((res, e) -> {
			if (e != null)
				return null;
			return res.toData();
		});
	}

	protected <X> CompletableFuture<X> getAsync(RiotRequest<X> request) {
		this.getIreliaQueue(request.getEndpoint()).put(request);
		CompletableFuture<X> result = new CompletableFuture<>();
		request.getFuture().handle((res, t) -> {
			if (t != null) {
				log.warn(t.getMessage());
				return null;
			}
			return res.toAPIData();
		}).whenComplete((data, ex) -> {
			if (ex == null) {
				result.complete(data);
				return;
			}
			Throwable root = ex.getCause() != null ? ex.getCause() : ex;
			if (root instanceof RiotResponseException && ((RiotResponseException) root).getCode() == 404) {
				result.complete(null);
			} else {
				result.completeExceptionally(root);
			}
		});
		return result;
	}

}
