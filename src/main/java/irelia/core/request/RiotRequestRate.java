package irelia.core.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RiotRequestRate{

    private int count1=0, time1=0, count2=0, time2=0;

    private static final Pattern PATTERN =  Pattern.compile("(\\d{1,5}):(\\d{1,5}),(\\d{1,5}):(\\d{1,5})");

    public RiotRequestRate(){

    }

    public RiotRequestRate(String header){
        this.setHeader(header);
    }

    public void setHeader(String header){
        if(header == null)
            return;
        Matcher matcher = PATTERN.matcher(header);
        if(!matcher.find())
            return;
        if(matcher.groupCount() != 4)
            return;
        this.count1 = Integer.parseInt(matcher.group(1));
        this.time1 = Integer.parseInt(matcher.group(2));
        this.count2 = Integer.parseInt(matcher.group(3));
        this.time2 = Integer.parseInt(matcher.group(4));
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }

    public int getTime1() {
        return time1;
    }

    public int getTime2() {
        return time2;
    }

    public boolean isNewCount1(){
        return count1 == 1;
    }

    public boolean isNewCount2(){
        return count2 == 1;
    }

    public boolean isLimit1(RiotRequestRate limit){
        return count1 == limit.count1;
    }

    public boolean isLimit2(RiotRequestRate limit){
        return count2 == limit.count2;
    }

    @Override
    public String toString() {
        return "%d:%d,%d:%d".formatted(count1, time1, count2, time2);
    }

}