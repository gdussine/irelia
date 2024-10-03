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
		this.next = irelia.getAppRateLimiter();
		this.endpoint = endpoint;
	}

	@Override
	protected void run(RiotRequest<?> request) throws InterruptedException {
		if (rates != null) {
			long timeToWait = rates.getTimeToWait();
			if (timeToWait > 0) {
				this.log.warn("Method rate limite reach. Wait for %s ms".formatted(timeToWait));
				Thread.sleep(timeToWait);
			}
		}
		next.submit(request).thenAccept(respons -> {
			String limitHeader = respons.headers().firstValue(METHOD_RATE_LIMIT_HEADER).orElse(null);
			String countHeader = respons.headers().firstValue(METHOD_RATE_COUNT_HEADER).orElse(null);
			if (this.rates == null)
				this.rates = new RiotRequestRates(limitHeader, countHeader);
			else {
				rates.updateCounts(limitHeader, countHeader);
			}
		});
	}

	@Override
	protected String getName() {
		return super.getName() + "[%s]".formatted(endpoint);
	}

}
