package service;

import interfaces.InterfaceHitMissPlayer;
import model.*;

import java.util.Random;

public class HitMissChancePlayer implements InterfaceHitMissPlayer {

    @Override
    public Boolean hitMiss(Player player) {
        if (player.getRace() == Race.HUMAN){
            Random random = new Random();
            int chance = random.nextInt(100);
            double hit = Math.round(player.getLucky()* 0.5) + 70;
            if (chance < hit){
                System.out.println(player.getName() + " hit the enemy");
                return true;
            } else {
                System.out.println(player.getName() + " missed");
                return false;
            }
        }
        return false;
    }
}