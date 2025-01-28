package irelia.tools.tracker;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrackableQueue<T extends Trackable> {

    private List<T> queue = new ArrayList<>();

    private int selector = 0;

    private Duration period;

    public TrackableQueue(Duration period) {
        this.period = period;
    }

    public void await() throws InterruptedException {
        Thread.sleep(period.dividedBy(Math.max(queue.size(), 1)));
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public synchronized void add(T t) {
        queue.add(t);
    }

    public synchronized void remove(T t) {
        queue.remove(t);
        this.selector = selector - 1;
    }

    public int getSelector() {
        return selector;
    }

    public T getSelectedValue() {
        if (queue.size() == 0)
            return null;
        return queue.get(selector);
    }

    public synchronized T next() {
        this.selector = selector >= queue.size() - 1 ? 0 : selector + 1;
        return getSelectedValue();
    }

    @Override
    public String toString() {
        return Arrays.toString(queue.toArray());
    }

}
