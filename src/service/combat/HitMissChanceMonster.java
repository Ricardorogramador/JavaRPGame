package service.combat;

import interfaces.InterfaceHitMissMonster;
import model.Monster;

import java.util.Random;

public class HitMissChanceMonster implements InterfaceHitMissMonster {
    @Override
    public boolean hitMissMonster(Monster monster) {
        if (monster.getHp() > 0){
            Random random = new Random();
            int chance = random.nextInt(100);
            double hit = Math.round(monster.getLucky()* 0.5) + 50;
            if (chance < hit){
                System.out.println(monster.getName() + " hit you");
                return true;
            } else {
                System.out.println(monster.getName() +" missed");
                return false;
            }
        }
        return false;
    }
}
