package controller;

import DBConnection.PlayerDAO;
import service.*;
import model.Monster;
import model.Player;

import java.util.Scanner;

public class GameLoop {
    Player player;

    public GameLoop(Player player) {
        this.player = player;
    }

    PlayerDAO playerDAO = new PlayerDAO();
    Monster monster = null;
    RandomBattleGenerator generator = new RandomBattleGenerator();
    PotionLogic potionLogic = new PotionLogic();
    RestEvent restEvent = new RestEvent(potionLogic);
    BattleLogic logic = new BattleLogic();
    HumanLvlUp humanLvlUp = new HumanLvlUp();
    int option;
    int step = 0;
    Scanner enter = new Scanner(System.in);

    public void gameLoop() {
        while (player.isAlive()) {
            System.out.println("Press ENTER to do a step.");
            System.out.println("Total steps: " + step);
            enter.nextLine();
            step++;
            double roll = Math.random();
            if (roll < 0.2) {
                restEvent.event(player);
            } else {
                monster = generator.randomBattle(player);
                if (monster != null) {
                    System.out.println("A " + monster.getName() + " has appeared");
                    do {
                        System.out.println("The battle has started");
                        System.out.println("1. Attack");
                        System.out.println("2. Defense");
                        System.out.println("3. Use health potion");
                        option = enter.nextInt();
                        switch (option) {
                            case 1:
                                logic.attack(player, monster);
                                if (monster.getHp() <= 0) {
                                    humanLvlUp.levelUp(player, monster);
                                }
                                if (player.getHp() <= 0) {
                                    player.setAlive(false);
                                }
                                break;
                            case 2:
                                logic.defend(player, monster);
                                if (player.getHp() <= 0) {
                                    player.setAlive(false);
                                }
                                break;
                            case 3:
                                potionLogic.healthPotion(player);
                                break;
                        }
                    } while (monster.getHp() > 0 && player.isAlive());
                } else {
                    System.out.println("Another step");
                }
            }
        }
        System.out.println(player.getName() + " is dead");
        playerDAO.deletePlayer(player);
    }
}
