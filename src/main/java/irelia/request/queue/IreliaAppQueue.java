package irelia.request.queue;

import java.util.concurrent.TimeUnit;

import irelia.core.Irelia;
import irelia.request.core.RiotRequest;
import irelia.request.core.RiotResponse;
import irelia.request.rate.RiotRequestRates;

public class IreliaAppQueue extends IreliaQueue {

    private RiotRequestRates rates;
    

    public IreliaAppQueue(Irelia irelia) {
        super(irelia);
        this.rates = new RiotRequestRates("x-app-rate-limit", "x-app-rate-limit-count");
    }

    @Override
    public <X> void onResponseReceived(RiotResponse<X> response) {
        this.rates.update(response.headers());
    }

    @Override
    public <X>  void onRequestSend(RiotRequest<X>  request) {
        irelia.getQueueManager().getScheduler().schedule(() -> {
            irelia.getHttpQueue().put(request);
        }, rates.getWaitingTime(), TimeUnit.MILLISECONDS);
    }

}
