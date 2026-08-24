package irelia.service;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.slf4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.IreliaLogger;
import irelia.request.core.RiotDataMapper;
import irelia.request.core.RiotRequest;
import irelia.request.core.RiotRequestBuilder;
import irelia.request.core.RiotRequestType;
import irelia.request.core.RiotResponse;
import irelia.request.exceptions.RiotResponseException;
import irelia.request.queue.IreliaQueue;

public class RiotService {

	protected Irelia irelia;
	protected RiotDataMapper mapper;
	protected Logger log;

	public RiotService() {
		this.mapper = new RiotDataMapper();
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

	protected <X> CompletableFuture<RiotResponse<X>> sendAsync(RiotRequest<X> request) {
		this.getIreliaQueue(request.getEndpoint()).put(request);
		return request.getFuture().thenApply(response -> {
			if (response.statusCode() / 100 > 2)
				throw new RiotResponseException(response);
			return response;
		});
	}

	public <X> CompletableFuture<X> getRiotObject(RiotRequest<X> request) {
		return this.sendAsync(request)
				.thenApply(response -> mapper.asRiotDTO(response))
				.handle((riotObject, ex) -> {
					if (ex == null)
						return riotObject;
					Throwable root = ex.getCause() != null ? ex.getCause() : ex;
					if (root instanceof RiotResponseException && ((RiotResponseException) root).getCode() == 404)
						return null;
					else
						throw new CompletionException(root);
				});
	}

	public CompletableFuture<byte[]> getData(RiotRequest<byte[]> request) {
		return this.sendAsync(request).thenApply(response -> mapper.asBytes(response))
				.handle((data, ex) -> {
					if (ex != null)
						return null;
					return data;
				});
	}

	public CompletableFuture<String> getString(RiotRequest<byte[]> request){
		return this.sendAsync(request).thenApply(response -> new String(mapper.asBytes(response), StandardCharsets.UTF_8))
			.handle((data,ex) ->{
				if(ex != null)
					return null; 
				return data;
			});
	}

}
