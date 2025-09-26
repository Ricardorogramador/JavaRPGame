package service;

import interfaces.InterfaceCritChanceMonster;
import model.Monster;

import java.util.Random;

public class MonsterCritChance implements InterfaceCritChanceMonster {
    @Override
    public Boolean critChance(Monster monster) {
        if (monster.getHp() > 0){
            Random random = new Random();
            int chance = random.nextInt(100);
            double crit = Math.round(monster.getLucky()* 0.3) + 10;
            if (chance < crit){
                System.out.println("The enemy attack was crit");
                return true;
            } else {
                return false;
            }
        }
        return null;
    }
}
