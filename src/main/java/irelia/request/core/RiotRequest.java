package irelia.request.core;

import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.request.limit.v3.RiotResponse;

public class RiotRequest<T> {

	private HttpRequest request;
	private long startTime;
	private TypeReference<T> type;
	private String endpoint;
	private RiotRequestType requestType;
	private CompletableFuture<RiotResponse<T>> future;

	public RiotRequest(HttpRequest request, RiotRequestType requestType, TypeReference<T> type, String endpoint) {
		this.request = request;
		this.startTime = System.currentTimeMillis();
		this.endpoint = endpoint;
		this.type = type;
		this.requestType = requestType;
		this.future = new CompletableFuture<>();
	}

	public HttpRequest getRequest() {
		return request;
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

	public RiotRequestType getRequestType() {
		return requestType;
	}

	public CompletableFuture<RiotResponse<T>> getFuture() {
		return future;
	}

	@Override
	public String toString() {
		return request.toString();
	}

}
