package irelia.core.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.core.Region;
import irelia.core.request.RiotRequest;
import irelia.core.request.RiotRequestBuilder;
import irelia.core.request.RiotRequestException;
import irelia.core.request.RiotRequestRate;
import irelia.core.request.RiotRequestType;
import irelia.core.request.StatusObject;

public class RiotService {

	protected Irelia irelia;
	protected ObjectMapper mapper;

	public RiotService(Irelia irelia) {
		this.irelia = irelia;
		mapper = new ObjectMapper();

	}

	protected <T> RiotRequest<T> createAPIRequest(TypeReference<T> type, Region region, String uri, Object... args) {
		return new RiotRequestBuilder<T>(irelia, type).setRequestType(RiotRequestType.API).setPlatform(region).setURI(uri, args)
				.build();
	}

	protected <T> RiotRequest<T> createAPIRequest(TypeReference<T> type, Platform platform, String uri, Object... args) {
		return new RiotRequestBuilder<T>(irelia, type).setRequestType(RiotRequestType.API).setPlatform(platform)
				.setURI(uri, args).build();
	}

	protected <T>RiotRequest<T> createDDragonRequest(TypeReference<T> type, String uri, Object... args) {
		return new RiotRequestBuilder<T>(irelia, type).setRequestType(RiotRequestType.DDRAGON).setURI(uri, args).build();
	}
	
	protected CompletableFuture<InputStream> getInputStreamAsync(RiotRequest<?> request) {
		CompletableFuture<InputStream> result = new CompletableFuture<InputStream>();
		irelia.getHttp().sendAsync(request.getRequest(), BodyHandlers.ofByteArray()).thenAcceptAsync(respons -> {
			String limitHeader = respons.headers().firstValue("x-app-rate-limit").orElse(null);
			RiotRequestRate limit = new RiotRequestRate(limitHeader);
			System.out.println(limit);
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
		CompletableFuture<T> result = new CompletableFuture<>();
		CompletableFuture<InputStream> futureInput = this.getInputStreamAsync(request);
		futureInput.exceptionally(e ->{
			result.completeExceptionally(e);
			return null;
		}).thenAccept(in -> {
			try {
				T t = mapper.readValue(in, request.getType());
				result.complete(t);
			} catch (Exception e) {
				result.completeExceptionally(e);
			}
		});
		return result;
	}

}
