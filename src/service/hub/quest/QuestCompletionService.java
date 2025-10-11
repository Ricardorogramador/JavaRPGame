package service.hub.quest;

import DBConnection.QuestDAO;
import model.Monster;
import model.Player;
import model.Quest;

import java.util.List;

public class QuestCompletionService {
    QuestDAO questDAO = new QuestDAO();
    QuestRewardCalculation questRewardCalculation = new QuestRewardCalculation();
    public void checkQuestProgress(Player player, Monster defeatedMonster){
        List<Quest> activeQuest = questDAO.getAssociatedQuest(player.getId());

        for (Quest quest : activeQuest){
            if (quest.getTargetName().equalsIgnoreCase(defeatedMonster.getName())){
                int newProgress = questDAO.incrementQuestProgress(player.getId(), quest.getIdQuest());

                if (newProgress >= quest.getRequiredAmount()){
                    questDAO.completedQuest(player.getId(), quest.getIdQuest());
                    System.out.println("Mission completed: " + quest.getQuestName());
                    questRewardCalculation.questRewardCalculation(player,quest);
                } else {
                    System.out.println("Progress: " + newProgress + "/" + quest.getRequiredAmount());
                }
            }
        }
    }
}
