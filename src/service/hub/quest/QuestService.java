package service.hub.quest;

import DBConnection.QuestDAO;
import model.Player;
import model.Quest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestService {
    QuestDAO questDAO = new QuestDAO();
    Scanner input = new Scanner(System.in);

    public void setQuest(Player player, int selectedQuestId){
        List<Quest> quests = questDAO.getAllQuest();
        Quest selectedQuest = null;
        for (Quest quest : quests){
            if (quest.getIdQuest() == selectedQuestId){
                selectedQuest = quest;
                break;
            }
        }
        if (selectedQuest == null){
            System.out.println("You selected an invalid ID quest");
            return;
        }
        if (player.getLevelPlayer() < selectedQuest.getRequiredLevel()){
            System.out.println("You need to reach level: " + selectedQuest.getRequiredLevel() + " to accept this quest");
        }

        if (questDAO.countActiveQuest(player.getId()) < 3){
            questDAO.createQuestRelation(player, selectedQuest);
            System.out.println("You accepted the quest: " + selectedQuest.getQuestName());
        } else {
            System.out.println("You already have 3 active quest. Complete one before accepting a new one");
        }
    }

    public void showQuest(Player player){
        List<Quest> quests = questDAO.getAllQuest();
        for (Quest quest : quests) {
            if (player.getLevelPlayer() >= quest.getRequiredLevel()) {
                System.out.println("ID: " + quest.getIdQuest() +
                        " | Name: " + quest.getQuestName() +
                        " | Description: " + quest.getQuestDescription());
                System.out.println("----------------------------");
            }
        }
        System.out.println("Select the ID quest you want to accept");
        int option = input.nextInt();
        setQuest(player, option);
    }
}
