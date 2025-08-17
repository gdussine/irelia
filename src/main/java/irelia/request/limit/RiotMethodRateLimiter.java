package irelia.request.limit;

import irelia.core.Irelia;
import irelia.request.core.RiotRequest;

public class RiotMethodRateLimiter extends RiotRequestManager {

	public static final String METHOD_RATE_LIMIT_HEADER = "x-method-rate-limit";
	public static final String METHOD_RATE_COUNT_HEADER = "x-method-rate-limit-count";

	private RiotRequestRates rates;
	private String endpoint;
	private RiotRequestManager next;

	public RiotMethodRateLimiter(Irelia irelia, String endpoint) {
		super(irelia);
		this.next = null;
		this.endpoint = endpoint;
		this.rates = new RiotRequestRates();
	}

	@Override
	protected void run(RiotRequest<?> request) throws InterruptedException {
		long timeToWait = rates.getWaitingTime();
		if (timeToWait > 0) {
			this.log.warn("Method rate limite reach. Wait for %s ms".formatted(timeToWait));
			Thread.sleep(timeToWait);
		}
		next.submit(request).handle((respons, t) -> {
			if (respons == null) {
				this.log.error("Request Error: %s.".formatted(t.getClass().getSimpleName()));
				return respons;
			}
			String limitHeader = respons.headers().firstValue(METHOD_RATE_LIMIT_HEADER).orElse(null);
			String countHeader = respons.headers().firstValue(METHOD_RATE_COUNT_HEADER).orElse(null);
			rates.update(limitHeader, countHeader);
			return respons;
		});
	}

	@Override
	public String getName() {
		return super.getName() + "[%s]".formatted(endpoint);
	}

}
