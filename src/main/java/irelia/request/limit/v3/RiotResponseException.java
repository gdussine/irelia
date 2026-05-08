package irelia.request.limit.v3;

import irelia.request.core.RiotRequestStatus;
import irelia.request.core.RiotRequestStatusObject;

public class RiotResponseException extends RuntimeException{
    

    private RiotRequestStatusObject status;

    public RiotResponseException(RiotRequestStatusObject object){
        super(object.getStatus().toString());
        this.status = object;
    }

    public RiotRequestStatusObject getStatus() {
        return status;
    }

}
