package model;

public class Quest {
    private int idQuest;
    private String questName;
    private String questDescription;
    private int requiredLevel;
    private boolean activeQuest;
    private boolean completedQuest;
    private String targetName;
    private int requiredAmount;
    private double xpQuest;
    private  int goldQuest;

    public Quest(int idQuest, String questName, String questDescription, int requiredLevel, boolean activeQuest, boolean completedQuest, String targetName, int requiredAmount, double xpQuest, int goldQuest) {
        this.idQuest = idQuest;
        this.questName = questName;
        this.questDescription = questDescription;
        this.requiredLevel = requiredLevel;
        this.activeQuest = activeQuest;
        this.completedQuest = completedQuest;
        this.targetName = targetName;
        this.requiredAmount = requiredAmount;
        this.xpQuest = xpQuest;
        this.goldQuest = goldQuest;
    }

    public double getXpQuest() {
        return xpQuest;
    }

    public void setXpQuest(double xpQuest) {
        this.xpQuest = xpQuest;
    }

    public int getGoldQuest() {
        return goldQuest;
    }

    public void setGoldQuest(int goldQuest) {
        this.goldQuest = goldQuest;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getIdQuest() {
        return idQuest;
    }

    public void setIdQuest(int idQuest) {
        this.idQuest = idQuest;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }

    public boolean isActiveQuest() {
        return activeQuest;
    }

    public void setActiveQuest(boolean activeQuest) {
        this.activeQuest = activeQuest;
    }

    public boolean isCompletedQuest() {
        return completedQuest;
    }

    public void setCompletedQuest(boolean completedQuest) {
        this.completedQuest = completedQuest;
    }
}
