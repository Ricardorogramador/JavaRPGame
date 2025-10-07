package service.player;

import DBConnection.PlayerDAO;
import model.Monster;
import model.Player;
import interfaces.*;

import java.util.Scanner;

public class HumanLvlUp implements LevelUpStrategy {
    private final PlayerDAO playerDAO = new PlayerDAO();
    private final int counter = 2;
    private final Scanner enter = new Scanner(System.in);
    private final UpdateStats updateStats = new UpdateStats();

    @Override
    public void levelUp(Player player, Monster monster) {
        double xpGain = Math.round(player.getWisdom() * 1.2) + monster.getGiveXP();
        double xpTotal = player.getXp() + xpGain;
        double xpNeeded = player.getMaximumXP();

        double multiplier = getXpMultiplier(player.getLevelPlayer());

        while (xpTotal >= xpNeeded) {
            handleLevelUp(player, xpGain, xpTotal, multiplier);
            xpTotal -= xpNeeded;
            xpNeeded = player.getMaximumXP();
        }
    }

    private double getXpMultiplier(int level) {
        if (level <= 5) return 1.3;
        else if (level <= 10) return 1.4;
        else return 1.5;
    }

    private void handleLevelUp(Player player, double xpGain, double xpTotal, double multiplier) {
        int newLevel = player.getLevelPlayer() + 1;
        System.out.println("You level up!");
        System.out.println("Your new level is: " + newLevel);

        StatsDistributor.distributeStats(player, counter, enter);
        updateStats.statsUpdate(player);

        player.setLevelPlayer(newLevel);
        player.setMaximumXP(player.getMaximumXP() * multiplier);
        player.setHp(player.getMaximumHP());
        player.setXp(xpTotal);
        playerDAO.updatePlayer(player);

        System.out.println("XP gained: " + xpGain);
        System.out.println("Your xp -> " + player.getXp() + "/" + player.getMaximumXP() + " <- XP needed to lvl up");
    }
}
