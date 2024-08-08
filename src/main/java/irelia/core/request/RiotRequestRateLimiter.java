package irelia.core.request;

import java.util.ArrayList;
import java.util.List;

public class RiotRequestRateLimiter<T> {

    private String endpoint;

    private long period1, period2;

    private RiotRequestRate limit;

    private RiotRequestRate lastCount;

    private List<RiotRequest<T>> queue;

    private Thread runner;

    public RiotRequestRateLimiter(String endpoint) {
        this.endpoint = endpoint;
        queue = new ArrayList<>();
        period1 = System.currentTimeMillis();
        period2 = System.currentTimeMillis();
        limit = new RiotRequestRate();
        lastCount = new RiotRequestRate();
    }

    public void setRespons(RiotRequestRate limit, RiotRequestRate lastCount) {
        this.limit = limit;
        this.lastCount = lastCount;
        long currentTime = System.currentTimeMillis();
        if (lastCount.isNewCount1())
            this.period1 = currentTime;
        if (lastCount.isNewCount2())
            this.period2 = currentTime;
    }

    public void runner(){
        this.runner = new Thread(()->{
            boolean running = true;
            while (running) {
                try {
                    long waitingMilis = 1;
                    long currentTime = System.currentTimeMillis();
                    if (lastCount.isLimit1(limit))
                        waitingMilis = period1 + limit.getTime1() - currentTime;
                    if (lastCount.isLimit2(limit))
                        waitingMilis = Math.max(waitingMilis, period2 + limit.getTime2() - currentTime);
                    Thread.sleep(waitingMilis);

                    
                } catch (InterruptedException e) {
                    running = false;
                }
            }
        }); 
        
    }

    public void submit(RiotRequest request) {
        
        
        
    }

    public String getEndpoint() {
        return endpoint;
    }
}