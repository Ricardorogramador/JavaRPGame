package service.Battle;

import model.Monster;
import model.Player;
import service.combat.*;

public class BattleLogic {
    HitMissChancePlayer hitPlayer = new HitMissChancePlayer();
    HitMissChanceMonster hitMonster = new HitMissChanceMonster();
    PlayerCounterAttack counterAttack = new PlayerCounterAttack();
    HumanCritChance humanCritChance = new HumanCritChance();
    MonsterCritChance monsterCritChance = new MonsterCritChance();

    public void attack(Player player, Monster monster) {
        double finalDamagePlayer = DamageCalculator.calculateDamage(player.getAttack(), monster.getDefense());
        double finalDamageMonster = DamageCalculator.calculateDamage(monster.getAttack(), player.getDefense());

        if (hitPlayer.hitMiss(player)) {
            if (humanCritChance.critChance(player)){
                double critDamage = Math.round(finalDamagePlayer * 1.5);
                double hpMonsterCrit = monster.getHp() - critDamage;
                System.out.println("Your damage was: " + critDamage);
                monster.setHp(hpMonsterCrit);
                System.out.println("Total " + monster.getName() + " HP: " + monster.getHp());
            } else {
                double hpMonster = monster.getHp() - Math.round(finalDamagePlayer);
                System.out.println("Your damage was: " + Math.round(finalDamagePlayer));
                monster.setHp(hpMonster);
                System.out.println("Total " + monster.getName() + " HP: " + monster.getHp());
            }
        }

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
        }
    }

    public void defend(Player player, Monster monster) {
        System.out.println("You rise your defense");
        System.out.println("The enemy attack you");
        double finalDamageMonster = DefenseCalculator.defenseCalculator(monster.getAttack(), player.getDefense());
        if (counterAttack.counterAttack(player)) {
            double counter = Math.round(finalDamageMonster / 2);
            System.out.println("Counter damage was: " + counter);
            double hpCounter = monster.getHp() - counter;
            monster.setHp(hpCounter);
            System.out.println("Total " + monster.getName() + " HP: " + monster.getHp());
        } else {
            System.out.println("Total damage: " + Math.round(finalDamageMonster));
            double playerHP = player.getHp() - Math.round(finalDamageMonster);
            player.setHp(playerHP);
            System.out.println("Total " + player.getName() + " HP: " + player.getHp());
        }
    }
}