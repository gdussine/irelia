package irelia;

import java.util.Locale;

import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import irelia.core.Irelia;
import irelia.core.Platform;
import irelia.tools.Launcher;

public class IreliaExtension implements BeforeAllCallback, AfterAllCallback, ParameterResolver {

    Launcher launcher;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        this.launcher = new Launcher(Platform.EUW1, Locale.FRANCE);

    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        this.launcher.close();

    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Irelia.class;
    }

    @Override
    public @Nullable Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
                return launcher.getIrelia();
    }
}

