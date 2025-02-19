package irelia.data.league;

import java.util.List;

public class LeagueList {

    private String leagueId;
    private List<LeagueItem> entries;
    private LeagueTier tier;
    private String name;
    private LeagueQueueType queue;
    public String getLeagueId() {
        return leagueId;
    }
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LeagueQueueType getQueue() {
        return queue;
    }
    public void setQueue(LeagueQueueType queue) {
        this.queue = queue;
    }

    

}
