package controller;

import DBConnection.PlayerDAO;
import model.Monster;
import model.Player;
import interfaces.AreaInterface;
import service.battle.BattleLogic;
import service.battle.MonsterTurn;
import service.battle.PotionLogic;
import service.battle.SkillsLogic;
import service.event.RestEvent;
import service.hub.quest.QuestCompletionService;
import service.player.HumanLvlUp;

import java.util.Random;
import java.util.Scanner;

public class GameLoop {

    private final Player player;
    private final AreaInterface area;

    private final Random random = new Random();
    private final PlayerDAO playerDAO = new PlayerDAO();
    private final PotionLogic potionLogic = new PotionLogic();
    private final RestEvent restEvent = new RestEvent(potionLogic);
    private final Scanner scanner = new Scanner(System.in);
    private final BattleLogic battleLogic = new BattleLogic();
    private final HumanLvlUp humanLvlUp = new HumanLvlUp();
    private final SkillsLogic skillsLogic = new SkillsLogic();
    private final MonsterTurn monsterTurn = new MonsterTurn();
    private final QuestCompletionService questCompletionService = new QuestCompletionService();

    private int totalSteps = 0;
    private int stepsTaken = 0;

    public GameLoop(Player player, AreaInterface area) {
        this.player = player;
        this.area = area;
    }

    public void explore() throws InterruptedException {
        System.out.println("Exploring: " + area.getName());
        System.out.println("How many steps do you want to take?");
        totalSteps = scanner.nextInt();

        while (totalSteps > 0 && player.isAlive()) {
            System.out.println("\nYou take a step forward...");
            Thread.sleep(2000);
            totalSteps--;
            stepsTaken++;

            int chance = random.nextInt(100) + 1; // 1–100

            Monster monster = area.generatorMonster(player, chance);

            if (monster != null) {
                System.out.println("A " + monster.getName() + " appears!");
                startBattle(player, monster);
            } else if (area.isRestEvent(chance)) {
                restEvent.event(player);
            } else {
                System.out.println("The path is quiet... you move on.");
            }
        }

        if (!player.isAlive()) {
            System.out.println(player.getName() + " has fallen in battle...");
            playerDAO.deletePlayer(player);
        } else {
            System.out.println("\nYou've finished exploring the " + area.getName() +
                    " after " + stepsTaken + " steps.");
        }
    }

    private void startBattle(Player player, Monster monster) {
        int option;

        do {
            System.out.println("\nThe battle begins!");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Skills");
            System.out.println("4. Use health potion");
            option = scanner.nextInt();
            playerDAO.updatePlayer(player);
            switch (option) {
                case 1:
                    battleLogic.attack(player, monster);
                    monsterTurn.monsterAttack(player,monster);
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + " has been defeated!");
                        questCompletionService.checkQuestProgress(player,monster);
                        humanLvlUp.levelUp(player, monster);
                    }
                    break;
                case 2:
                    battleLogic.defend(player, monster);
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + " has been defeated!");
                        questCompletionService.checkQuestProgress(player,monster);
                        humanLvlUp.levelUp(player, monster);
                    }
                    break;
                case 3:
                    skillsLogic.showSKills(player,monster);
                    monsterTurn.monsterAttack(player,monster);
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + " has been defeated!");
                        questCompletionService.checkQuestProgress(player,monster);
                        humanLvlUp.levelUp(player, monster);
                    }
                    break;
                case 4:
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
