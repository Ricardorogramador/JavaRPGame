package service;

import model.Monster;
import model.Player;

public class BattleLogic {
    HitMissChancePlayer hitPlayer = new HitMissChancePlayer();
    HitMissChanceMonster hitMonster = new HitMissChanceMonster();
    PlayerCounterAttack counterAttack = new PlayerCounterAttack();

    public void attack(Player player, Monster monster) {
        double playerRawDamage = player.getAttack();
        double monsterRawDamage = monster.getAttack();
        double damageReductionMonster = monster.getDefense() / (monster.getDefense() + 100);
        double damageReductionPlayer = player.getDefense() / (player.getDefense() + 100);
        double finalDamagePlayer = playerRawDamage * (1 - damageReductionMonster);
        double finalDamageMonster = monsterRawDamage * (1 - damageReductionPlayer);

        if (hitPlayer.hitMiss(player)) {
            double hpMonster = monster.getHp() - Math.round(finalDamagePlayer);
            System.out.println("Your damage was: " + Math.round(finalDamagePlayer));
            monster.setHp(hpMonster);
            System.out.println("Total " + monster.getName() + " HP: " + monster.getHp());
        }
        if (hitMonster.hitMissMonster(monster)) {
            double hpPlayer = player.getHp() - Math.round(finalDamageMonster);
            System.out.println("The enemy damage was: " + Math.round(finalDamageMonster));
            player.setHp(hpPlayer);
            System.out.println("Total " + player.getName() + " HP: " + player.getHp());
        }
    }

    public void defend(Player player, Monster monster) {
        System.out.println("You rise your defense");
        double defenseUP = player.getDefense() / (player.getDefense() + 150);
        double monsterRawDamage = monster.getAttack();
        System.out.println("The enemy attack you");
        double finalDamageMOnster = monsterRawDamage * (1 - defenseUP);
        if (counterAttack.counterAttack(player)) {
            double counter = Math.round(finalDamageMOnster / 2);
            System.out.println("Counter damage was: " + counter);
            double hpCounter = monster.getHp() - counter;
            monster.setHp(hpCounter);
            System.out.println("Total " + monster.getName() + " HP: " + monster.getHp());
        } else {
            System.out.println("Total damage: " + Math.round(finalDamageMOnster));
            double playerHP = player.getHp() - Math.round(finalDamageMOnster);
            player.setHp(playerHP);
            System.out.println("Total " + player.getName() + " HP: " + player.getHp());
        }
    }
}
