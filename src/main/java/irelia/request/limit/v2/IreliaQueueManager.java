package irelia.request.limit.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;

import irelia.core.IreliaLogger;

public class IreliaQueueManager {

    ThreadFactory schedulerFactory = new ThreadFactory() {
        AtomicInteger n = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "IreliaScheduler-%d".formatted(n.incrementAndGet()));
        }
    };

    ThreadFactory executorFactory = new ThreadFactory() {
        AtomicInteger n = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "IreliaExecutor-%d".formatted(n.incrementAndGet()));
        }
    };

    protected final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2, schedulerFactory);
    protected final ExecutorService executor = Executors.newCachedThreadPool(executorFactory);
    private Logger log = IreliaLogger.LIMITER.logger(getClass());

    public void start(IreliaQueue queue) {
        executor.submit(queue::run);

    }

    public IreliaMethodQueue start(IreliaMethodQueue queue) {
        executor.submit(queue::run);
        return queue;
    }

    public void stopExecutor(ExecutorService executor, String name) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                log.debug("Queue \"{}\" shutdown forced", name);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("Queue \"%s\" interrupted during shutdown".formatted(name), e);
        }
        log.debug("Queue \"{}\" shutdown", name);
    }

    public void stop() {
        scheduler.shutdownNow();
        executor.shutdownNow();
    }

    public ScheduledExecutorService getScheduler() {
        return scheduler;
    }

    public ExecutorService getExecutor() {
        return executor;
    }

}
