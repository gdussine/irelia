package irelia.api;

import java.util.concurrent.CompletableFuture;

import irelia.data.status.StatusPlatform;

public interface StatusAPI {

    public CompletableFuture<StatusPlatform> platformData();

}
