package demo.tools;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import irelia.core.Irelia;
import irelia.tools.Launcher;

public class LauncherTest {

    @Test
    public void getIrelia() {
        Irelia irelia = Launcher.startIrelia();
        assertNotNull(irelia);
        assertTrue(irelia.isRunning());
    }

}
