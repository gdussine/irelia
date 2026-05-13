package irelia.request.limit.v2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;

import irelia.core.Irelia;
import irelia.core.IreliaLogger;
import irelia.request.core.RiotRequest;
import irelia.request.limit.v3.RiotResponse;

public abstract class IreliaQueue {

    ThreadFactory factory = new ThreadFactory() {
        private final AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Scheduler-%s-%d".formatted(getName(), count.getAndIncrement()));
        }
    };

    protected final BlockingQueue<RiotRequest<?>> queue = new LinkedBlockingQueue<>();
    protected final Irelia irelia;
    protected final Logger log = IreliaLogger.LIMITER.logger(getClass());

    public IreliaQueue(Irelia irelia) {
        this.irelia = irelia;
    }

    public abstract <X> void onResponseReceived(RiotResponse<X> response) throws InterruptedException;

    public abstract <X> void onRequestSend(RiotRequest<X> request) throws InterruptedException;

    public void onStopped() {

    }

    public void put(RiotRequest<?> request) {
        try {
            this.queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public RiotRequest<?> get() throws InterruptedException {
        return queue.take();
    }

    public void run() {
        try {
            log.debug("Queue \"{}\" run", getName());
            RiotRequest<?> request = null;
            do {
                request = get();
                log.debug("Request \"{}\" send", request);
                if (request != null) {
                    onRequestSend(request);
                    RiotResponse<?> response = request.getFuture().join();
                    onResponseReceived(response);
                }
            } while (request != null);
            log.debug("Queue \"{}\" auto shutdown", getName());
        } catch (Exception e) {
            log.debug("Queue \"%s\" interrupted. (pending=%s)".formatted(getName(), queue));
        } finally {
            onStopped();
        }
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "%s[%s]".formatted(getName(), queue.toString());
    }

}
