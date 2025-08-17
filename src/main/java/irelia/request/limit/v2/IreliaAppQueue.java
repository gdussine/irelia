package irelia.request.limit.v2;

import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

import irelia.core.Irelia;
import irelia.request.core.RiotRequest;
import irelia.request.limit.RiotRequestRates;

public class IreliaAppQueue extends IreliaQueue {

    private RiotRequestRates rates;
    

    public IreliaAppQueue(Irelia irelia) {
        super(irelia);
        this.rates = new RiotRequestRates("x-app-rate-limit", "x-app-rate-limit-count");
    }

    @Override
    public void onResponseReceived(HttpResponse<byte[]> response) {
        this.rates.update(response.headers());
    }

    @Override
    public void onRequestSend(RiotRequest<?> request) {
        irelia.getQueueManager().getScheduler().schedule(() -> {
            irelia.getHttpQueue().put(request);
        }, rates.getWaitingTime(), TimeUnit.MILLISECONDS);
    }

}
