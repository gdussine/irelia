package irelia.request.limit;

import irelia.core.Irelia;
import irelia.request.core.RiotRequest;

public class RiotAppRateLimiter extends RiotRequestManager {

	public static final String APP_RATE_LIMIT_HEADER = "x-app-rate-limit";
	public static final String APP_RATE_COUNT_HEADER = "x-app-rate-limit-count";

	private RiotRequestRates rates;
	private RiotRequestSender next;

	public RiotAppRateLimiter(Irelia irelia) {
		super(irelia);
		this.next = irelia.getRequestSender();

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
		next.submit(request).handle((respons,t) -> {
			if(respons == null){
				this.log.error("Request Error: %s.".formatted(t.getClass().getSimpleName()));
				return respons;
			}
			String limitHeader = respons.headers().firstValue(APP_RATE_LIMIT_HEADER).orElse(null);
			String countHeader = respons.headers().firstValue(APP_RATE_COUNT_HEADER).orElse(null);
			if (this.rates == null)
				this.rates = new RiotRequestRates(limitHeader, countHeader);
			else {
				rates.updateCounts(limitHeader, countHeader);
			}
			return respons;
		});
	}

}
