package irelia.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum IreliaLogger {

    CORE("irelia.core.Irelia.%s"),
    SERVICE( "irelia.service.%s"),
    LIMITER("irelia.limiter.%s");


    private String label;

    private IreliaLogger(String label){
        this.label = label;
    }


    public Logger logger(Class<?> type){
        return LoggerFactory.getLogger(label.formatted(type.getSimpleName()));

    }

}
