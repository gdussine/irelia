package irelia.core;

public class IreliaException extends Exception{

    private static final String FAILED_START = "Irelia failed to start";

    public IreliaException(String message){
        super(message);
    }

    public IreliaException(String message, Throwable cause){
        super(message, cause);
    }

    public static IreliaException failedStart(Throwable cause){
        return new IreliaException(FAILED_START, cause);
    }


}
