package irelia.data.community;

import java.util.List;

public class QueueInfo {

    private int id;
    private String name;
    private String shortName;
    private String description;
    private String detailedDescription;
    private String gameSelectModeGroup;
    private String gameSelectCategory;
    private int gameSelectPriority;
    private boolean isSkillTreeQueue;
    private boolean isLimitedTimeQueue;
    private boolean isBotHonoringAllowed;
    private boolean hidePlayerPosition;
    private List<Integer> viableChampionRoster;
    private String pickMode;

    public QueueInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public String getGameSelectModeGroup() {
        return gameSelectModeGroup;
    }

    public void setGameSelectModeGroup(String gameSelectModeGroup) {
        this.gameSelectModeGroup = gameSelectModeGroup;
    }

    public String getGameSelectCategory() {
        return gameSelectCategory;
    }

    public void setGameSelectCategory(String gameSelectCategory) {
        this.gameSelectCategory = gameSelectCategory;
    }

    public int getGameSelectPriority() {
        return gameSelectPriority;
    }

    public void setGameSelectPriority(int gameSelectPriority) {
        this.gameSelectPriority = gameSelectPriority;
    }

    public boolean getIsSkillTreeQueue() {
        return isSkillTreeQueue;
    }

    public void setIsSkillTreeQueue(boolean isSkillTreeQueue) {
        this.isSkillTreeQueue = isSkillTreeQueue;
    }

    public boolean getIsLimitedTimeQueue() {
        return isLimitedTimeQueue;
    }

    public void setIsLimitedTimeQueue(boolean isLimitedTimeQueue) {
        this.isLimitedTimeQueue = isLimitedTimeQueue;
    }

    public boolean getIsBotHonoringAllowed() {
        return isBotHonoringAllowed;
    }

    public void setIsBotHonoringAllowed(boolean isBotHonoringAllowed) {
        this.isBotHonoringAllowed = isBotHonoringAllowed;
    }

    public boolean getHidePlayerPosition() {
        return hidePlayerPosition;
    }

    public void setHidePlayerPosition(boolean hidePlayerPosition) {
        this.hidePlayerPosition = hidePlayerPosition;
    }

    public List<Integer> getViableChampionRoster() {
        return viableChampionRoster;
    }

    public void setViableChampionRoster(List<Integer> viableChampionRoster) {
        this.viableChampionRoster = viableChampionRoster;
    }

    public String getPickMode() {
        return pickMode;
    }

    public void setPickMode(String pickMode) {
        this.pickMode = pickMode;
    }

    @Override
    public String toString() {
        return shortName;
    }

}
