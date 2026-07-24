package irelia.request.core;

public class RiotRequestQuery {

    protected String getQueryString(String[] attrName, Object[] attr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<attr.length; i++){
            if(attr[i] == null)
                continue;
            if(!sb.isEmpty())
                sb.append("&");
            sb.append(attrName[i]).append("=").append(attr[i]);
        }
        return sb.insert(0, "?").toString();
    }

}
