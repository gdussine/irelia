package irelia.request.limit;

public class RiotRequestRateObject {

    private RiotRequestRate limit;
    private RiotRequestRate count;
    private Long refresh;

    public RiotRequestRateObject(String limitHeader, String countHeader) {
        this.limit = new RiotRequestRate(limitHeader);
        this.count = new RiotRequestRate(countHeader);
        this.refresh = System.currentTimeMillis();
    }

    public void update(String limitHeader, String countHeader) {
        this.limit = new RiotRequestRate(limitHeader);
        this.count = new RiotRequestRate(countHeader);
        if (count.getCount() == 1) {
            this.refresh = System.currentTimeMillis();
        }
    }

    public long getWaitingTime() {
        if (count.getCount() != limit.getCount())
            return 0;
        return Math.max(0, refresh + limit.getTime() * 1000 - System.currentTimeMillis());
    }

    public long getLimitTime(){
        return this.limit.getTime();
    }

    @Override
    public String toString() {
        return "%s (%s)".formatted(count, limit);
    }

}
