package irelia.core.request;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RiotRequestRates {

	private List<RiotRequestRate> limits = new ArrayList<>();
	private List<RiotRequestRate> counts = new ArrayList<>();
	private List<Long> refresh = new ArrayList<>();

	public RiotRequestRates(String limitHeader, String countHeader) {
		Arrays.stream(limitHeader.split(",")).forEach(s -> limits.add(new RiotRequestRate(s)));
		Arrays.stream(countHeader.split(",")).forEach(s -> counts.add(new RiotRequestRate(s)));
		limits.forEach(x -> refresh.add(System.currentTimeMillis()));
	}

	public RiotRequestRates(List<RiotRequestRate> limits, List<RiotRequestRate> counts, List<Long> refresh) {
		this.limits = limits;
		this.counts = counts;
		this.refresh = refresh;
	}

	public RiotRequestRates updateCounts(String limitHeader, String countHeader) {
		String[] countHeaderStrings = countHeader.split(",");
		List<RiotRequestRate> newcounts = new ArrayList<>();
		List<Long> newrefresh = new ArrayList<>();
		for (int i = 0; i < countHeaderStrings.length; i++) {
			RiotRequestRate newcount = new RiotRequestRate(countHeaderStrings[i]);
			newcounts.add(newcount);
			if (newcount.getCount() == 1) {
				newrefresh.add(System.currentTimeMillis());
			} else {
				newrefresh.add(refresh.get(i));
			}
		}
		this.refresh = newrefresh;
		this.counts = newcounts;
		return this;
	}

	public RiotRequestRates(HttpHeaders headers) {
		this(headers.firstValue("x-app-rate-limit").orElse(null),
				// headers.firstValue("x-app-rate-limit-count").orElse(null),
				headers.firstValue("x-method-rate-limit").orElse(null));
		// ,headers.firstValue("x-method-rate-limit-count").orElse(null));
	}

	public long getTimeToWait() {
		long time = 0;
		for (int i = 0; i < limits.size(); i++) {
			if (counts.get(i).getCount() != limits.get(i).getCount())
				continue;
			time = Math.max(time, refresh.get(i) + limits.get(i).getTime()*1000 - System.currentTimeMillis() );
		}
		return Math.max(0, time);
	}

	@Override
	public String toString() {
		return "%s (%s)".formatted(counts, limits);
	}

}