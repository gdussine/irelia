package irelia.request.core;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

public class RiotRequest<T> {

	private HttpRequest request;
	private long startTime;
	private TypeReference<T> type;
	private CompletableFuture<T> result;
	private CompletableFuture<HttpResponse<byte[]>> payload;
	private String endpoint;
	private RiotRequestType requestType;

	public RiotRequest(HttpRequest request, RiotRequestType requestType, TypeReference<T> type, String endpoint) {
		this.request = request;
		this.startTime = System.currentTimeMillis();
		this.endpoint = endpoint;
		this.type = type;
		this.requestType = requestType;
		this.result = new CompletableFuture<>();
		this.payload = new CompletableFuture<>();
	}

	public HttpRequest getRequest() {
		return request;
	}

	public CompletableFuture<T> getResult() {
		return result;
	}

	public TypeReference<T> getType() {
		return type;
	}

	public long getStartTime() {
		return startTime;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public CompletableFuture<HttpResponse<byte[]>> getPayload() {
		return payload;
	}

	public RiotRequestType getRequestType() {
		return requestType;
	}

	@Override
	public String toString() {
		return request.toString();
	}

}
