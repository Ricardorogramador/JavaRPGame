package service;

import interfaces.InterfaceCritChance;
import model.Player;
import model.Race;

import java.util.Random;

public class HumanCritChance implements InterfaceCritChance {
    @Override
    public Boolean critChance(Player player) {
        if (player.getRace() == Race.HUMAN){
            Random random = new Random();
            int chance = random.nextInt(100);
            double crit = Math.round((player.getLucky()) * 0.3 ) + 10;
            if (chance < crit){
                System.out.println("Your attack was a double Crit");
                return true;
            } else {
                return false;
            }
        }
        return null;
    }
}
