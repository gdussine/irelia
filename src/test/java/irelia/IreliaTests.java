package irelia;

import java.util.Locale;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import irelia.core.Irelia;
import irelia.core.IreliaException;
import irelia.core.Platform;
import irelia.tools.Launcher;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class IreliaTests {

    protected static Irelia irelia;

    @BeforeAll
    public static void beforeAll() throws IreliaException {
        irelia = new Irelia(Launcher.getKeyFromProperties(), Platform.EUW1, Locale.FRANCE);
        irelia.start();
    }


    @AfterAll
    public static void afterAll() throws IreliaException {
        irelia.stop();
    }
}
