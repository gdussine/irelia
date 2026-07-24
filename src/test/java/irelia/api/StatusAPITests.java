package irelia.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import irelia.IreliaExtension;
import irelia.core.Irelia;
import irelia.data.status.StatusPlatform;

@ExtendWith(IreliaExtension.class)
public class StatusAPITests {

    @Test
    public void status( Irelia irelia){
        StatusPlatform status = irelia.status().platformData().join();
        assertNotNull(status.getId());
        assertNotNull(status.getName());
        assertNotNull(status.getLocales());
        assertNotNull(status.getMaintenances());
        assertNotNull(status.getIncidents());
    }

}
