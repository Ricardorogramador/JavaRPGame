package service.battle;

import model.Monster;
import model.Player;
import service.combat.*;
public class MonsterTurn {
    HitMissChanceMonster hitMonster = new HitMissChanceMonster();
    MonsterCritChance monsterCritChance = new MonsterCritChance();
    public void monsterAttack(Player player, Monster monster) {
        double finalDamageMonster = DamageCalculator.calculateDamage(monster.getAttack(), player.getDefense());

        if (hitMonster.hitMissMonster(monster)) {
            if (monsterCritChance.critChance(monster)){
                double critDamage = Math.round(finalDamageMonster * 1.5);
                double hpPlayerCrit = player.getHp() - critDamage;
                System.out.println(monster.getName() + " Damage was: " + critDamage);
                player.setHp(hpPlayerCrit);
                System.out.println("Total " + player.getName() + " HP: " + player.getHp());
            } else {
                double hpPlayer = player.getHp() - Math.round(finalDamageMonster);
                System.out.println("The enemy damage was: " + Math.round(finalDamageMonster));
                player.setHp(hpPlayer);
                System.out.println("Total " + player.getName() + " HP: " + player.getHp());
            }
        } else {
            System.out.println(monster.getName() + " missed the attack!");
        }
    }
}
