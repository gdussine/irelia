package irelia.data.league;

import java.util.List;

public class LeagueList {

    private List<LeagueItem> entries;
    private LeagueTier tier;
    private LeagueQueueType queue;

    public List<LeagueItem> getEntries() {
        return entries;
    }
    public void setEntries(List<LeagueItem> entries) {
        this.entries = entries;
    }
    public LeagueTier getTier() {
        return tier;
    }
    public void setTier(LeagueTier tier) {
        this.tier = tier;
    }
    public LeagueQueueType getQueue() {
        return queue;
    }
    public void setQueue(LeagueQueueType queue) {
        this.queue = queue;
    }

    

}
