package irelia.data.mastery;

public class NextSeasonMilestones {

    private Object requireGradeCounts;
    private int rewardMarks;
    private boolean bonus;
    private RewardConfig rewardConfig;
    private int totalGamesRequires;

    public Object getRequireGradeCounts() {
        return requireGradeCounts;
    }

    public void setRequireGradeCounts(Object requireGradeCounts) {
        this.requireGradeCounts = requireGradeCounts;
    }

    public int getRewardMarks() {
        return rewardMarks;
    }

    public void setRewardMarks(int rewardMarks) {
        this.rewardMarks = rewardMarks;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public RewardConfig getRewardConfig() {
        return rewardConfig;
    }

    public void setRewardConfig(RewardConfig rewardConfig) {
        this.rewardConfig = rewardConfig;
    }

    public int getTotalGamesRequires() {
        return totalGamesRequires;
    }

    public void setTotalGamesRequires(int totalGamesRequires) {
        this.totalGamesRequires = totalGamesRequires;
    }


}
