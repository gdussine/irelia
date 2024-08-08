package irelia.core.request;

import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

public class RiotRequest<T>{

	private HttpRequest request;
	private long startTime;
	private TypeReference<T> type;
	private CompletableFuture<T> result;

	public RiotRequest(HttpRequest request, TypeReference<T> type) {
		this.request = request;
		this.startTime = System.currentTimeMillis();
		this.type = type;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public CompletableFuture<T> getResult(){
		return result;
	}

	public TypeReference<T> getType() {
		return type;
	}

	public long getStartTime() {
		return startTime;
	}

	@Override
	public String toString() {
		return request.toString();
	}


}
