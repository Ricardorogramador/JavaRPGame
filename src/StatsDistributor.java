import java.util.Scanner;

public class StatsDistributor {
    public static void distributeStats(Player player, int points, Scanner input) {
        int counter = points;
        boolean statsComplete = false;
        do {
            if (!statsComplete) {
                System.out.println("1. 1+ point in strength");
                System.out.println("2. 1+ point in intelligence");
                System.out.println("3. 1+ point in wisdom");
                System.out.println("4. 1+ point in lucky");
                System.out.println("5. check your stats");
                System.out.println("points to be asigned: " + counter);
                int option = input.nextInt();
                switch (option) {
                    case 1:
                        int strength = player.getStrength() + 1;
                        player.setStrength(strength);
                        counter--;
                        break;
                    case 2:
                        int intelligence = player.getIntelligence() + 1;
                        player.setIntelligence(intelligence);
                        counter--;
                        break;
                    case 3:
                        int wisdom = player.getWisdom() + 1;
                        player.setWisdom(wisdom);
                        counter--;
                        break;
                    case 4:
                        int lucky = player.getLucky() + 1;
                        player.setLucky(lucky);
                        counter--;
                        break;
                    case 5:
                        System.out.println("Strength: " + player.getStrength());
                        System.out.println("Intelligence: " + player.getIntelligence());
                        System.out.println("Wisdom: " + player.getWisdom());
                        System.out.println("Lucky: " + player.getLucky());
                        System.out.println("points to be asigned: " + counter);
                        break;
                    default:
                        System.out.println("Invalid option, choose another.");
                }
                if (counter == 0) {
                    System.out.println("You don't have more points.");
                    statsComplete = true;
                }
            }
        } while (!statsComplete);
    }
}
