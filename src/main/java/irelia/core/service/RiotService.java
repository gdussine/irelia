package irelia.core.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.core.Region;
import irelia.core.request.RiotRequest;
import irelia.core.request.RiotRequestBuilder;
import irelia.core.request.RiotRequestException;
import irelia.core.request.RiotRequestType;
import irelia.core.request.Status;
import irelia.core.request.StatusObject;

public class RiotService {

	protected Irelia irelia;
	protected ObjectMapper mapper;

	public RiotService(Irelia irelia) {
		this.irelia = irelia;
		mapper = new ObjectMapper();

	}

	protected RiotRequest createAPIRequest(Region region, String uri, Object... args) {
		return new RiotRequestBuilder(irelia).setRequestType(RiotRequestType.API).setPlatform(region).setURI(uri, args)
				.build();
	}

	protected RiotRequest createAPIRequest(Platform platform, String uri, Object... args) {
		return new RiotRequestBuilder(irelia).setRequestType(RiotRequestType.API).setPlatform(platform)
				.setURI(uri, args).build();
	}

	protected RiotRequest createDDragonRequest(String uri, Object... args) {
		return new RiotRequestBuilder(irelia).setRequestType(RiotRequestType.DDRAGON).setURI(uri, args).build();
	}
	
	protected CompletableFuture<InputStream> getInputStreamAsync(RiotRequest request) {
		request.getRequest().uri().toString();
		CompletableFuture<InputStream> result = new CompletableFuture<InputStream>();
		irelia.getHttp().sendAsync(request.getRequest(), BodyHandlers.ofByteArray()).thenAcceptAsync(respons -> {
			try {
				if (respons.statusCode() / 100 != 2) {
					Status status = mapper.readValue(respons.body().toString(), StatusObject.class).getStatus();
					result.completeExceptionally(new RiotRequestException(request, status));
				}
				result.complete(new ByteArrayInputStream(respons.body()));
			} catch (JsonProcessingException e) {
				result.completeExceptionally(e);
			}
		});
		return result;
	}

	protected <T> CompletableFuture<T> getAsync(RiotRequest request, TypeReference<T> type) {
		CompletableFuture<T> result = new CompletableFuture<T>();
		irelia.getHttp().sendAsync(request.getRequest(), BodyHandlers.ofString()).thenAcceptAsync(respons -> {
			try {
				if (respons.statusCode() / 100 != 2) {
					Status status = mapper.readValue(respons.body(), StatusObject.class).getStatus();
					result.completeExceptionally(new RiotRequestException(request, status));
				}
				result.complete(mapper.readValue(respons.body(), type));
			} catch (JsonProcessingException e) {
				result.completeExceptionally(e);
			}
		});
		return result;
	}

}
