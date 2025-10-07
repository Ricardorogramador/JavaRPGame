package service.combat;

import interfaces.InterfaceHitMissPlayer;
import model.*;

import java.util.Random;

public class HitMissChancePlayer implements InterfaceHitMissPlayer {

    @Override
    public Boolean hitMiss(Player player) {
        int timehit =0;
        int timeloss =0;
        if (player.getRace() == Race.Human){
            Random random = new Random();
            int chance = random.nextInt(100);
            double hit = Math.round(player.getLucky()* 0.5) + 70;
            if (chance < hit){
                System.out.println(player.getName() + " hit the enemy");
                timehit++;
                return true;
            } else {
                System.out.println(player.getName() + " missed");
                timeloss++;
                return false;
            }
        }
        System.out.println("Hit times: " + timehit);
        System.out.println("Miss attacks: " + timeloss);
        return false;
    }
}