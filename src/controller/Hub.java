package controller;

import DBConnection.QuestDAO;
import model.Player;
import model.Quest;
import service.hub.AdventureService;
import service.hub.InnService;
import service.hub.ShopService;
import service.hub.quest.QuestCompletionService;
import service.hub.quest.QuestService;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hub {

    public void hub(Player player) throws InterruptedException {
        QuestDAO questDAO = new QuestDAO();
        QuestCompletionService qcs = new QuestCompletionService();
        QuestService questService = new QuestService();
        InnService innService = new InnService();
        ShopService service = new ShopService();
        Random random = new Random();
        AdventureService adventure = new AdventureService();
        System.out.println("Welcome to the Hub.");
        Scanner input = new Scanner(System.in);
        System.out.println("Here you can accept questlines, buy skills and rest");
        while (player.isAlive()){
            int option;
            System.out.println("There is a lot of things to do");
            System.out.println("Select one");
            System.out.println("1. Rest in inn");
            System.out.println("2. Shop");
            System.out.println("3. Adventure guild");
            System.out.println("4. Go out for adventures");
            System.out.println("5. Exit Hub");
            option = input.nextInt();
            switch (option){
                case 1:
                    System.out.println("Welcome to the inn");
                    System.out.println("Select your room.");
                    System.out.println("1. Good room. Price: 80");
                    System.out.println("2. Normal room. Price: 50");
                    System.out.println("3. Bad room. Price: 20");
                    System.out.println("Gold: " + player.getGold());
                    int inn = input.nextInt();
                    if (inn == 1 && player.getGold() >= 80){
                        System.out.println("This is our best room");
                        System.out.println("Have a good rest");
                        innService.goodRoom(player);
                        player.setGold(player.getGold() - 80);
                    } else if (inn == 2 && player.getGold() >= 50) {
                        System.out.println("This room is not our best but can give you a good rest");
                        innService.normalRoom(player);
                        player.setGold(player.getGold() - 50);
                    } else if (inn == 3 && player.getGold() >=20) {
                        System.out.println("The only room you can pay is this one");
                        System.out.println("Is not the best room but you can have rest... I think...");
                        innService.badRoom(player);
                        player.setGold(player.getGold() - 20);
                    } else {
                        System.out.println("You don't have enough gold to pay for a room");
                    }
                    break;
                case 2:
                    //TODO: Here goes shop logic.
                    System.out.println("You wandered around the market and see different shops");
                    System.out.println("1. Weapon shop");
                    System.out.println("2. Armor shop");
                    System.out.println("3. Magic shop");
                    System.out.println("4. Potion shop");
                    System.out.println("5. Leave");
                    option = input.nextInt();
                    switch (option){
                        case 1:
                            //TODO: Here goes weapon shop logic
                            break;
                        case 2:
                            //TODO: Here goes Armor shop logic
                            break;
                        case 3:
                            System.out.println("You see a beautiful woman with a orb in her hands and some shelves with book in the back");
                            System.out.println("Woman: Hey, are you looking for new skills? ");
                            System.out.println("Woman: Here is my catalogue, purchase your venom");
                            service.showSkillInShop(player);
                            break;
                        case 4:
                            //TODO: Here goes potion shop logic
                            break;
                        case 5:
                            System.out.println("Nothing catch your attention so you decide to leave");
                            break;
                        default:
                            System.out.println("You walk through the market but nothing catch your attention");
                            break;
                    }
                    break;
                case 3:
                    //TODO: Here goes Adventure guild logic or Quest logic.
                    System.out.println("You enter the Adventurer's Guild.");
                    System.out.println("Behind the counter, a woman greets you with a kind smile.");
                    System.out.println("Receptionist: Welcome, adventurer! Are you here for a quest?");
                    System.out.println("1. Show available quests");
                    System.out.println("2. Show my active quests");
                    System.out.println("3. Report a completed quest");
                    System.out.println("4. Leave the guild");
                    option = input.nextInt();
                    switch (option){
                        case 1:
                            questService.showQuest(player);
                            break;
                        case 2:
                         List<Quest> activeQuest = questDAO.getAssociatedQuest(player.getId());
                         if (activeQuest.isEmpty()){
                             System.out.println("You don't have active quest right now");
                         } else {
                             System.out.println("=== Your active quests ===");
                             for (Quest quest : activeQuest){
                                 System.out.println("• " + quest.getQuestName() + " - " + quest.getQuestDescription());
                             }
                         }
                            break;
                        case 3:
                            List<Quest> completedQuests = questDAO.getCompletedQuest(player.getId());
                            if (completedQuests.isEmpty()) {
                                System.out.println("You haven't completed any quests yet.");
                            } else {
                                System.out.println("=== Completed Quests ===");
                                for (Quest quest : completedQuests) {
                                    System.out.println("• " + quest.getQuestName() + " (Reward: " + quest.getGoldQuest() + " gold, "
                                            + quest.getXpQuest() + " XP)");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("You decide to do other thing");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("You decide to go for adventures!");
                    System.out.println("Where you want to go?");
                    System.out.println("1. Forest");
                    System.out.println("2. Cave");
                    option = input.nextInt();
                    switch (option){
                        case 1:
                            System.out.println("You head toward the Forest");
                            adventure.forestArea(player);
                            break;
                        case 2:
                            System.out.println("You descend into the dark caves");
                            adventure.caveArea(player);
                            break;
                        default:
                            System.out.println("You wander aimlessly, looking for adventure...");
                            int chance = random.nextInt(100);
                            if (chance <=60){
                                System.out.println("You stumble upon the Forest!");
                                adventure.forestArea(player);
                            } else {
                                System.out.println("You find yourself near the entrance of the Caves!");
                                adventure.caveArea(player);

                            }
                    }
                    break;
                case 5:
                    System.out.println("Leaving the Hub");
                    return;
                default:
                    System.out.println("Select a valid option");
            }
        }
    }
}
