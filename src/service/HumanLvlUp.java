package service;

import DBConnection.PlayerDAO;
import model.Monster;
import model.Player;
import interfaces.*;

import java.util.Scanner;

public class HumanLvlUp implements LevelUpStrategy {
    PlayerDAO playerDAO = new PlayerDAO();
    int counter = 2;
    Scanner enter = new Scanner(System.in);
    UpdateStats updateStats = new UpdateStats();
    public void levelUp(Player player, Monster monster) {
        double xpToLvlUp = player.getMaximumXP();
        double xpCalculation = Math.round(player.getWisdom() * 1.2) + monster.getGiveXP();
        double xpCalculationTotal = xpCalculation + player.getXp();
        while (xpCalculationTotal >= xpToLvlUp){
            int lvlUp = player.getLevelPlayer() + 1;
            System.out.println("You level up!");
            System.out.println("Your new level is: " + lvlUp);
            StatsDistributor.distributeStats(player, counter, enter);
            updateStats.statsUpdate(player);
            player.setLevelPlayer(lvlUp);
            xpCalculationTotal -= xpToLvlUp;
            //TO ADJUST
            double maximumXP = player.getMaximumXP() * 1.3;
            player.setMaximumXP(maximumXP);
            player.setHp(player.getMaximumHP());
            player.setXp(xpCalculation);
        }
        player.setXp(xpCalculationTotal);
        System.out.println("XP gained: " + xpCalculation);
        System.out.println("Your xp -> " + player.getXp() + "/" + player.getMaximumXP() + " <- XP needed to lvl up");
        playerDAO.updatePlayer(player);
    }
}