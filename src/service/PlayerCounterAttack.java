package service;

import interfaces.InterfaceCounterAttack;
import model.Player;
import model.Race;

import java.util.Random;

public class PlayerCounterAttack implements InterfaceCounterAttack {
    @Override
    public boolean counterAttack(Player player) {
        if (player.getRace() == Race.Human){
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
