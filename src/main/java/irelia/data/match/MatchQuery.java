package irelia.data.match;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import irelia.data.community.QueueTypes;

public class MatchQuery {

    public enum Type {
        ranked, normal, tourney, tutorial;
    }

    private Integer count;
    private Integer start;
    private Long startTime;
    private Long endTime;
    private Long queue;
    private Type type;

    public MatchQuery(Integer count, Integer start, Long startTime, Long endTime, QueueTypes queue, Type type) {
        this.setCount(count);
        this.setStart(start);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setQueue(queue);
        this.setType(type);
    }

    public MatchQuery() {

    }

    public MatchQuery setCount(Integer count) {
        this.count = count;
        return this;
    }

    public MatchQuery setStart(Integer start) {
        this.start = start;
        return this;
    }

    public MatchQuery setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public MatchQuery setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

    public MatchQuery setQueue(QueueTypes queue) {
        this.queue = queue == null ? null : queue.getId();
        ;
        return this;
    }

    public MatchQuery setType(Type type) {
        this.type = type;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getStart() {
        return start;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Long getQueue() {
        return queue;
    }

    public Type getType() {
        return type;
    }

    public String getQueryString() {
        ArrayList<String> params = new ArrayList<>();
        for (Field field : getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()))
                continue;
            Object param = null;

            try {
                param = field.get(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (param == null)
                continue;
            params.add("%s=%s".formatted(field.getName(), param));
        }
        if (params.size() == 0)
            return "";
        else
            return "?" + String.join("&", params);
    }

}
