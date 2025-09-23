import java.util.Scanner;

public class GameLoop {
    Player player;

    public GameLoop(Player player) {
        this.player = player;
    }

    Monster monster = null;
    RandomBattleGenerator generator = new RandomBattleGenerator();
    BattleLogic logic = new BattleLogic();
    int option;
    int step = 0;
    Scanner  enter = new Scanner(System.in);

    public void gameLoop(){
        while (player.isAlive()) {
            step++;
            enter.nextLine();
            monster = generator.randomBattle(player);
            if (monster != null){
                System.out.println("A " + monster.getName() + " has appeared");
                do {
                    System.out.println("The battle has started");
                    System.out.println("1. Attack");
                    System.out.println("2. Defense");
                    option = enter.nextInt();
                    switch (option){
                        case 1:
                            logic.attack(player, monster);
                            if (monster.getHp()<=0){
                                logic.levelUP(player, monster);
                            }
                            if (player.getHp() <= 0){
                                player.setAlive(false);
                            }
                            break;
                        case 2:
                            logic.defend(player, monster);
                            if (player.getHp() <= 0){
                                player.setAlive(false);
                            }
                            break;
                    }
                } while (monster.getHp() > 0 && player.isAlive());
            } else {
                System.out.println("Another step");
            }
            }
        System.out.println(player.getName() + " is dead");
        if (player.getId_player().equals("Ricardo")){
            System.out.println("Player has been deleted");
        }
        }
    }
