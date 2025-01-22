package irelia.data.community;

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

    @Override
    public String toString() {
        return shortName;
    }

}
