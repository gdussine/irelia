package irelia.core.request.limit;

import irelia.core.Irelia;
import irelia.core.request.RiotRequest;
import irelia.core.request.RiotRequestRates;

public class RiotAppRateLimiter extends RiotRequestManager {

	public static final String APP_RATE_LIMIT_HEADER = "x-app-rate-limit";
	public static final String APP_RATE_COUNT_HEADER = "x-app-rate-limit-count";
	public static final String METHOD_RATE_LIMIT_HEADER = "x-method-rate-limit";
	public static final String METHOD_RATE_COUNT_HEADER = "x-method-rate-limit-count";

	private RiotRequestRates rates;

	public RiotAppRateLimiter(Irelia irelia) {
		super(irelia, irelia.getRequestSender());

	}

	@Override
	protected void run(RiotRequest<?> request) throws InterruptedException {
		if (rates != null) {
			long timeToWait = rates.getTimeToWait();
			if (timeToWait > 0) {
				this.log.warn("App rate limite reach. Wait for %s ms".formatted(timeToWait));
				Thread.sleep(timeToWait);
			}
		}
		next.submit(request).thenAccept(respons -> {
			String limitHeader = respons.headers().firstValue(APP_RATE_LIMIT_HEADER).orElse(null);
			String countHeader = respons.headers().firstValue(APP_RATE_COUNT_HEADER).orElse(null);
			if (this.rates == null)
				this.rates = new RiotRequestRates(limitHeader, countHeader);
			else {
				rates.updateCounts(limitHeader, countHeader);
			}
		});
	}

}
