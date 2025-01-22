package irelia.service;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.data.status.StatusPlatform;
import irelia.request.core.RiotRequest;
import irelia.service.impl.RateLimitedRiotService;

public class StatusService extends  RateLimitedRiotService {

    private final static String PLATFORM_URI = "lol/status/v4/platform-data";

    public StatusService(Irelia irelia) {
        super(irelia);
    }

    public CompletableFuture<StatusPlatform> platformData() {
        TypeReference<StatusPlatform> type = new TypeReference<StatusPlatform>() {};
        RiotRequest<StatusPlatform> request = this.createAPIRequest(type, irelia.getPlatform(), PLATFORM_URI);
        return getAsync(request);
    }

    public CompletableFuture<Boolean> isUp() {
        TypeReference<StatusPlatform> type = new TypeReference<StatusPlatform>() {};
        RiotRequest<StatusPlatform> request = this.createAPIRequest(type, irelia.getPlatform(), PLATFORM_URI);
        return getAsync(request).handle((platform, t) -> t == null);
    }

}
