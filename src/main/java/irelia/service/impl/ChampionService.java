package irelia.service.impl;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.ChampionAPI;
import irelia.data.champion.ChampionRotation;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class ChampionService extends RateLimitedRiotService implements ChampionAPI{

    private final static String ROTATIONS = "lol/platform/v3/champion-rotations";

    @Override
    public CompletableFuture<ChampionRotation> rotations() {
        TypeReference<ChampionRotation> type = new TypeReference<ChampionRotation>() {};
        RiotRequest<ChampionRotation> request = this.createAPIRequest(type, irelia.getPlatform(), ROTATIONS);
        return getAsync(request);
    }

}
