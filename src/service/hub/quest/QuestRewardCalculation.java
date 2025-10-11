package service.hub.quest;

import model.Player;
import model.Quest;

public class QuestRewardCalculation {

    public void questRewardCalculation(Player player, Quest quest){
        player.setGold(player.getGold() + quest.getGoldQuest());
        player.setXp(player.getXp() + quest.getXpQuest());
    }
}
