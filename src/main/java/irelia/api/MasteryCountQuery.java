package irelia.api;

import irelia.request.core.RiotRequestQuery;

public class MasteryCountQuery extends RiotRequestQuery {

    private int count;

    public MasteryCountQuery(int count) {
        this.count = count;
    }

    public String getQueryString() {
        String[] attrName = { "count" };
        Object[] attr = { count };
        return super.getQueryString(attrName, attr);
    }

}
