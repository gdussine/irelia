package irelia.core.request;

import java.net.http.HttpRequest;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class RiotRequest implements Delayed{

	private HttpRequest request;
	private long startTime;

	public RiotRequest(HttpRequest request) {
		this.request = request;
		this.startTime = System.currentTimeMillis();
	}

	public HttpRequest getRequest() {
		return request;
	}
	
	public void delay(long millis) {
		this.startTime += millis;
	}

	@Override
	public int compareTo(Delayed o) {
		return Long.compare(startTime, ((RiotRequest) o).startTime);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	public static class Builder {

		
	}

	@Override
	public String toString() {
		return request.toString();
	}


}
