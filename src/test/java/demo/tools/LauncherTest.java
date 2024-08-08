package demo.tools;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import irelia.core.Irelia;
import irelia.tools.Launcher;

public class LauncherTest {
    
    @Test
    public void getLauncherInitTest(){
        Irelia irelia = Launcher.getIrelia();
        assertNotNull(irelia);
    }

}
