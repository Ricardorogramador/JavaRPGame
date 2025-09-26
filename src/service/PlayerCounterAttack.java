package service;

import interfaces.InterfaceCunterAttack;
import model.Player;
import model.Race;

import java.util.Random;

public class PlayerCounterAttack implements InterfaceCunterAttack {
    @Override
    public boolean counterAttack(Player player) {
        if (player.getRace() == Race.HUMAN){
            Random random = new Random();
            int chance = random.nextInt(100);
            if (chance < 20){
                System.out.println(player.getName() + "You parried the attack!!");
                return true;
            } else {
                System.out.println("You receive the full damage");
                return false;
            }
        }
        return false;
    }
}
