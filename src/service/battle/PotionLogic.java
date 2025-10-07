package service.battle;

import model.Player;

public class PotionLogic {

    public void healthPotion(Player player){
        if (player.getHealthPotion() >= 1){
            int potion = player.getHealthPotion() - 1;
            player.setHealthPotion(potion);
            System.out.println("You use a health potion");
            double health = Math.round(player.getMaximumHP() * 0.30);
            double totalHealth = player.getHp() + health;
            if (totalHealth >= player.getMaximumHP()){
                player.setHp(player.getMaximumHP());
            } else {
                player.setHp(totalHealth);
            }
            System.out.println("You feel reinvigorated");
            System.out.println(player.getName() + " HP " + player.getHp());
        } else {
            System.out.println("You don't have health potions");
        }
    }

    public void manaPotion(Player player){
        if (player.getManaPotion() >=1){
            int manaPotion = player.getManaPotion() - 1;
            player.setManaPotion(manaPotion);
            System.out.println("You use a mana potion");
            //TO ADJUST
            double mana = Math.round(player.getMaximumMana() * 0.30);
            double totalMana = player.getMana() + mana;
            if (totalMana >= player.getMaximumMana()){
                player.setMana(player.getMaximumMana());
            } else {
                player.setMana(totalMana);
            }
            System.out.println("You feel reinvigorated");
            System.out.println(player.getName() + " MP " + player.getMana());
        } else {
            System.out.println("You don't have mana potion");
        }
    }
    public void updatePotions(Player player){
        boolean restored = false;
        if (player.getHealthPotion() < 3){
            player.setHealthPotion(player.getHealthPotion() +1);
            System.out.println("Your health potions has been restored by one");
            restored = true;
        }
        if (player.getManaPotion() <3){
            player.setManaPotion(player.getManaPotion()+1);
            System.out.println("Your mana potions has been restored by one");
            restored = true;
        }
        if (!restored){
            System.out.println("Your potions are full");
        }
        System.out.println("Number of health potion: " + player.getHealthPotion());
        System.out.println("Number of mana potion: " + player.getManaPotion());
    }
}
