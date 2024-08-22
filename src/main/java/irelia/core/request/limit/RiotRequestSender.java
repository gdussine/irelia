package irelia.core.request.limit;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import irelia.core.Irelia;
import irelia.core.request.RiotRequest;

public class RiotRequestSender extends RiotRequestManager {

	public static final String METHOD_RATE_LIMIT_HEADER = "x-method-rate-limit";
	public static final String METHOD_RATE_COUNT_HEADER = "x-method-rate-limit-count";

	public RiotRequestSender(Irelia irelia) {
		super(irelia);
	}

	@Override
	protected void run(RiotRequest<?> request) throws InterruptedException {
		try {
			HttpResponse<byte[]> respons = irelia.getHttp().send(request.getRequest(), BodyHandlers.ofByteArray());
			request.getPayload().complete(respons);
		} catch (IOException e) {
			request.getPayload().completeExceptionally(e);
		}

	}

}
