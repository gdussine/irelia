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

    public String getQueryString(){
        StringBuilder sb = new StringBuilder();
        Object[] attr = {count, start, startTime, endTime, queue, type};
        String[] attrName = {"count", "start", "startTime", "endTime", "queue", "type"};
        for(int i = 0; i<attr.length; i++){
            if(attr[i] == null)
                continue;
            if(!sb.isEmpty())
                sb.append("&");
            sb.append(attrName[i]).append("=").append(attr[i]);
        }
        sb.insert(0, "?");
        return sb.toString();


    }

}
