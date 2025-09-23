public class Logic1 {

public void attack(Player player, Monster monster){
    double playerRawDamage = player.getAttack();
    double monsterRawDamage = monster.getAttack();
    double damageReductionMonster = monster.getDefense() / (monster.getDefense() + 100);
    double damageReductionPlayer = player.getDefense() / (player.getDefense() + 100);
    double finalDamagePlayer = playerRawDamage * (1 - damageReductionMonster);
    double finalDamageMonster = monsterRawDamage * (1 - damageReductionPlayer);
    System.out.println("You hit the enemy");
    double hpMonster = monster.getHp() - Math.round(finalDamagePlayer);
    System.out.println("Your damage was: " + Math.round(finalDamagePlayer));
    monster.setHp(hpMonster);
    System.out.println("Total " + monster.getName() + " HP: " + monster.getHp());
    System.out.println("The enemy hit you");
    double hpPlayer = player.getHp() - Math.round(finalDamageMonster);
    System.out.println("The enemy damage was: " + Math.round(finalDamageMonster));
    player.setHp(hpPlayer);
    System.out.println("Total " + player.getName() + " HP: " + player.getHp());
    }

    public void defend(Player player, Monster monster){
        System.out.println("You rise your defense");
        double defenseUP = player.getDefense() / (player.getDefense() + 150);
        double monsterRawDamage = monster.getAttack();
        System.out.println("The enemy attack you");
        double finalDamageMOnster = monsterRawDamage * (1 - defenseUP);
        System.out.println("Total damage: " + Math.round(finalDamageMOnster));
        double playerHP = player.getHp() - Math.round(finalDamageMOnster);
        player.setHp(playerHP);
        System.out.println("Total " + player.getName() + " HP: " + player.getHp());
    }

    public void levelUP(Player player, Monster monster){
    double xpToLvlUp = player.getMaximumXP();
    double xpCalculation = (player.getWisdom() * 1.2) + monster.getGiveXP() + player.getXp();
    if (xpCalculation >= xpToLvlUp){
        int lvlUp = player.getLevelPlayer() + 1;
        System.out.println("You level up: " + lvlUp);
        player.setLevelPlayer(lvlUp);
        double maximumXP = player.getMaximumXP() * 1.2;
        player.setMaximumXP(maximumXP);
        player.setXp(0);
        }
    player.setXp(xpCalculation - xpToLvlUp);
    }
}
