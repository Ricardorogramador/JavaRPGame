import java.util.Scanner;

public class HumanLvlUp implements LevelUpStrategy {
    int counter = 2;
    Scanner enter = new Scanner(System.in);

    public void levelUp(Player player, Monster monster) {
        double xpToLvlUp = player.getMaximumXP();
        double xpCalculation = (player.getWisdom() * 1.2) + monster.getGiveXP() + player.getXp();
        while (xpCalculation >= xpToLvlUp){
            int lvlUp = player.getLevelPlayer() + 1;
            System.out.println("You level up: " + lvlUp);
            StatsDistributor.distributeStats(player, counter, enter);
            player.setLevelPlayer(lvlUp);
            xpCalculation -= xpToLvlUp;
            //TO ADJUST
            double maximumXP = player.getMaximumXP() * 1.3;
            player.setMaximumXP(maximumXP);
            player.setHp(player.getMaximumHP());
            player.setXp(0);
        }
        player.setXp(xpCalculation);
        System.out.println("XP gained: " + xpCalculation);
        System.out.println("Your xp -> " + player.getXp() + "/" + player.getMaximumXP() + " <- XP needed to lvl up");
    }
}