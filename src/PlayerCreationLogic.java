    import java.util.Scanner;

    public class PlayerCreationLogic implements PlayerCalculation{
        Scanner enter = new Scanner(System.in);

        public void createPlayer(Player player) {
            System.out.println("--Character creation--");
            System.out.println("Introduce your name");
            String name = enter.next();
            player.setName(name);
            System.out.println("Now distribute your stats");
            player.setStrength(1);
            player.setWisdom(1);
            player.setLucky(1);
            player.setIntelligence(1);
            StatsDistributor.distributeStats(player, 10, enter);
            System.out.println("Good luck in your journey");
        }

        @Override
        public void calculatePlayer(Player player) {
            player.setAlive(true);
            double hp;
            hp = 100 + (player.getStrength() * 5);
            player.setHp(hp);
            double attack = 10 + (player.getStrength() * 1.5);
            player.setAttack(attack);
            double defense = 5 + (player.getDefense() * 1.2);
            player.setDefense(defense);
        }
    }
