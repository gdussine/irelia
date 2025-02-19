package irelia.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import irelia.data.ddragon.Champions;
import irelia.data.mastery.ChampionMastery;

public interface MasteryAPI {


    public CompletableFuture<List<ChampionMastery>> byPuuid(String puuid);
    
    public CompletableFuture<ChampionMastery> byChampion(String puuid, Long championId);

    public CompletableFuture<ChampionMastery> byChampion(String puuid, Champions champions);

    public CompletableFuture<List<ChampionMastery>> top(String puuid);
    
    public CompletableFuture<Integer> score(String puuid);
    
}
