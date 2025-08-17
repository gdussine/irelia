package irelia.request.limit;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

public class RiotRequestRates {

	private List<RiotRequestRateObject> rates;
	private String limitHeaderName, countHeaderName;

	public RiotRequestRates() {
	}

	public RiotRequestRates(String limitHeaderName, String countHeaderName ){
		this.limitHeaderName = limitHeaderName;
		this.countHeaderName = countHeaderName;

	}

	public void update(HttpHeaders headers){
        this.update(headers.firstValue(limitHeaderName).orElse(null), headers.firstValue(countHeaderName).orElse(null));
	}

	public void update(String limitHeaders, String countHeaders) {
		String[] limitHeaderArray = limitHeaders.split(",");
		String[] countHeaderArray = countHeaders.split(",");
		if (rates == null) {
			rates = new ArrayList<>();
			for (int i = 0; i < limitHeaderArray.length; i++) {
				rates.add(new RiotRequestRateObject(limitHeaderArray[i], countHeaderArray[i]));
			}
		} else
			for (int i = 0; i < countHeaderArray.length; i++) {
				rates.get(i).update(limitHeaderArray[i], countHeaderArray[i]);
			}
	}

	public long getWaitingTime() {
		if(rates == null)
			return 0;
		return rates.stream().map(x -> x.getWaitingTime()).max(Long::compareTo).orElse(0L);
	}

	public long getMaxiumTime(){
		if(rates == null)
			return 0;
		return rates.stream().map(x->x.getLimitTime()).max(Long::compareTo).orElse(0L);
	}

	@Override
	public String toString() {
		return rates.toString();
	}

}