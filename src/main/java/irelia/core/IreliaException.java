package irelia.core;

import irelia.service.RiotService;

public class IreliaException extends RuntimeException{

    private static final String FAILED_START = "Irelia failed to start";
    private static final String KEY_NOT_FOUND = "Riot API Key not found";
    private static final String KEY_ILLEGAL = "Illegal Riot API Key";
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

    public static IreliaException keyNotFound(Throwable cause){
        return new IreliaException(KEY_NOT_FOUND, cause);
    }

      public static IreliaException keyIllegal(){
        return new IreliaException(KEY_ILLEGAL);
    }

    public static IreliaException riotServiceFailedStop(RiotService service, Throwable cause){
        return new IreliaException(FAILED_STOP.formatted(service.getName()), cause);
    }

    


}
