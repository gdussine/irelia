package irelia.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.api.MasteryAPI;
import irelia.data.ddragon.Champions;
import irelia.data.mastery.ChampionMastery;
import irelia.request.core.RiotRequest;
import irelia.service.RateLimitedRiotService;

public class MasteryService extends RateLimitedRiotService implements MasteryAPI {

    private static String BY_PUUID_URI = "lol/champion-mastery/v4/champion-masteries/by-puuid/%s";
    private static String BY_CHAMPION_URI = "/lol/champion-mastery/v4/champion-masteries/by-puuid/%s/by-champion/%s";
    private static String TOP_URI = "lol/champion-mastery/v4/champion-masteries/by-puuid/%s/top";
    private static String SCORES_URI = "/lol/champion-mastery/v4/scores/by-puuid/%s";

    @Override
    public CompletableFuture<List<ChampionMastery>> byPuuid(String puuid) {
        TypeReference<List<ChampionMastery>> type = new TypeReference<>() {
        };
        RiotRequest<List<ChampionMastery>> request = this.createAPIRequest(type, irelia.getRegion(), BY_PUUID_URI,
                puuid);
        return getAsync(request);
    }

    @Override
    public CompletableFuture<ChampionMastery> byChampion(String puuid, Long championId) {
        TypeReference<ChampionMastery> type = new TypeReference<ChampionMastery>() {
        };
        RiotRequest<ChampionMastery> request = this.createAPIRequest(type, irelia.getRegion(), BY_CHAMPION_URI, puuid,
                championId);
        return getAsync(request);
    }

    @Override
    public CompletableFuture<ChampionMastery> byChampion(String puuid, Champions champion) {
        TypeReference<ChampionMastery> type = new TypeReference<ChampionMastery>() {
        };
        RiotRequest<ChampionMastery> request = this.createAPIRequest(type, irelia.getRegion(), BY_CHAMPION_URI, puuid,
                champion.getKey());
        return getAsync(request);
    }

    @Override
    public CompletableFuture<List<ChampionMastery>> top(String puuid) {
        TypeReference<List<ChampionMastery>> type = new TypeReference<>() {
        };
        RiotRequest<List<ChampionMastery>> request = this.createAPIRequest(type, irelia.getRegion(), TOP_URI, puuid);
        return getAsync(request);
    }

    @Override
    public CompletableFuture<Integer> score(String puuid) {
        TypeReference<Integer> type = new TypeReference<>() {
        };
        RiotRequest<Integer> request = this.createAPIRequest(type, irelia.getRegion(), SCORES_URI, puuid);
        return getAsync(request);
    }

}
