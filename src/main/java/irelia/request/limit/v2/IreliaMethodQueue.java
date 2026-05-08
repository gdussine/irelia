package irelia.request.limit.v2;

import java.util.concurrent.TimeUnit;

import irelia.core.Irelia;
import irelia.request.core.RiotRequest;
import irelia.request.limit.RiotRequestRates;
import irelia.request.limit.v3.RiotResponse;
import irelia.service.RateLimitedRiotService;

public class IreliaMethodQueue extends IreliaQueue {

    private final RiotRequestRates rates;
    private final String endpoint;
    private RateLimitedRiotService service;

    public IreliaMethodQueue(Irelia irelia, String endpoint, RateLimitedRiotService service) {
        super(irelia);
        this.endpoint = endpoint;
        this.service = service;
        rates = new RiotRequestRates("x-method-rate-limit", "x-method-rate-limit-count");
    }

    @Override
    public RiotRequest<?> get() throws InterruptedException {
        return queue.poll(Math.max(5, rates.getMaxiumTime()), TimeUnit.SECONDS);
    }

    @Override
    public <X> void onResponseReceived(RiotResponse<X> response) {
        rates.update(response.headers());
    }

    @Override
    public <X> void onRequestSend(RiotRequest<X>  request) {
        irelia.getQueueManager().getScheduler().schedule(() -> {
            irelia.getAppQueue().put(request);
        }, rates.getWaitingTime(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void onStopped() {
        service.disconnectQueue(this);
    }

    @Override
    public String getName() {
        return super.getName() + "[" + endpoint + "]";
    }

    public String getEndpoint() {
        return endpoint;
    }

}
