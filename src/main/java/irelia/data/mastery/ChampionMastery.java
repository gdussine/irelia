package irelia.data.mastery;

import java.util.List;

public class ChampionMastery {

    private String puuid;
    private long championPointsUntilNextLevel;
    private boolean chestGranted;
    private long championId;
    private long lastPlayTime;
    private int championLevel;
    private int championPoints;
    private long championPointsSinceLastLevel;
    private int markRequiredForNextLevel;
    private int championSeasonMilestone;
    private NextSeasonMilestones nextSeasonMilestone;
    private int tokensEarned;
    private List<String> milestoneGrades;

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public long getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public void setChampionPointsUntilNextLevel(long championPointsUntilNextLevel) {
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    }

    public boolean isChestGranted() {
        return chestGranted;
    }

    public void setChestGranted(boolean chestGranted) {
        this.chestGranted = chestGranted;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public long getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(long lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(int championLevel) {
        this.championLevel = championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(int championPoints) {
        this.championPoints = championPoints;
    }

    public long getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public void setChampionPointsSinceLastLevel(long championPointsSinceLastLevel) {
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    }

    public int getMarkRequiredForNextLevel() {
        return markRequiredForNextLevel;
    }

    public void setMarkRequiredForNextLevel(int markRequiredForNextLevel) {
        this.markRequiredForNextLevel = markRequiredForNextLevel;
    }

    public int getChampionSeasonMilestone() {
        return championSeasonMilestone;
    }

    public void setChampionSeasonMilestone(int championSeasonMilestone) {
        this.championSeasonMilestone = championSeasonMilestone;
    }

    public NextSeasonMilestones getNextSeasonMilestone() {
        return nextSeasonMilestone;
    }

    public void setNextSeasonMilestone(NextSeasonMilestones nextSeasonMilestone) {
        this.nextSeasonMilestone = nextSeasonMilestone;
    }

    public int getTokensEarned() {
        return tokensEarned;
    }

    public void setTokensEarned(int tokensEarned) {
        this.tokensEarned = tokensEarned;
    }

    public List<String> getMilestoneGrades() {
        return milestoneGrades;
    }

    public void setMilestoneGrades(List<String> milestoneGrades) {
        this.milestoneGrades = milestoneGrades;
    }

}
