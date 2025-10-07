package controller;

import DBConnection.PlayerDAO;
import model.Monster;
import model.Player;
import service.battle.BattleLogic;
import service.battle.PotionLogic;
import service.battle.RandomBattleGenerator;
import service.event.RestEvent;
import service.player.HumanLvlUp;

import java.util.Random;
import java.util.Scanner;

public class GameLoop {
    Player player;

    public GameLoop(Player player) {
        this.player = player;
    }

    Random random = new Random();
    int totalSteps = 0;
    int stepsTaken = 0;
    Monster monster = null;
    PlayerDAO playerDAO = new PlayerDAO();
    PotionLogic potionLogic = new PotionLogic();
    RestEvent restEvent = new RestEvent(potionLogic);
    Scanner scanner = new Scanner(System.in);
    BattleLogic logic = new BattleLogic();
    HumanLvlUp humanLvlUp = new HumanLvlUp();
    RandomBattleGenerator randomBattleGenerator = new RandomBattleGenerator();

    public void area(Player player) throws InterruptedException {
        System.out.println("Select the area you want to explore:");
        System.out.println("1. Forest");
        int option = scanner.nextInt();

        System.out.println("How many steps do you want to take?");
        totalSteps = scanner.nextInt();

        while (totalSteps > 0 && player.isAlive()) {
            System.out.println("\nYou take a step forward...");
            Thread.sleep(2000);
            totalSteps--;
            stepsTaken++;

            int chance = random.nextInt(100) + 1; // 1–100

            if (option == 1) {
                if (chance <= 40) { // 60% batalla
                    monster = randomBattleGenerator.randomBattleForest(player);
                    if (monster != null) {
                        startBattle(player, monster);
                    } else {
                        System.out.println("You sense danger... but nothing appears.");
                    }

                } else if (chance <= 70) { // 20% descanso
                    restEvent.event(player);

                } else { // 20% paso vacío
                    System.out.println("The path is quiet... you move on.");
                }
            }
        }

        if (!player.isAlive()) {
            System.out.println(player.getName() + " has fallen in battle...");
            playerDAO.deletePlayer(player);
        } else {
            System.out.println("\nYou've finished exploring this area after " + stepsTaken + " steps.");
        }
    }

    private void startBattle(Player player, Monster monster) {
        System.out.println("A " + monster.getName() + " appears!");

        int option;
        do {
            System.out.println("\nThe battle begins!");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Use health potion");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    logic.attack(player, monster);
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + " has been defeated!");
                        humanLvlUp.levelUp(player, monster);
                    }
                    break;

                case 2:
                    logic.defend(player, monster);
                    break;

                case 3:
                    potionLogic.healthPotion(player);
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }

            if (player.getHp() <= 0) {
                player.setAlive(false);
            }

        } while (monster.getHp() > 0 && player.isAlive());
    }
}
