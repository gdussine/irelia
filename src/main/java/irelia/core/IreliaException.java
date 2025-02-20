package irelia.core;

import irelia.request.limit.RiotRequestManager;
import irelia.service.RiotService;

public class IreliaException extends Exception{

    private static final String FAILED_START = "Irelia failed to start";
    private static final String FAILED_STOP = "%s failed to stop";

    public IreliaException(String message){
        super(message);
    }

    public IreliaException(String message, Throwable cause){
        super(message, cause);
    }

    public static IreliaException failedStart(Throwable cause){
        return new IreliaException(FAILED_START, cause);
    }

    public static IreliaException riotRequestManagerFailedStop(RiotRequestManager rrm, Throwable cause){
        return new IreliaException(FAILED_STOP.formatted(rrm.getName()), cause);
    }

    public static IreliaException riotServiceFailedStop(RiotService service, Throwable cause){
        return new IreliaException(FAILED_STOP.formatted(service.getName()), cause);
    }


}
