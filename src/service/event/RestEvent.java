package service.event;

import model.Player;

import java.util.Random;
import java.util.Scanner;
import interfaces.*;
import service.battle.PotionLogic;

public class RestEvent implements EventsInterface {
    private final PotionLogic potionLogic;

    public RestEvent(PotionLogic potionLogic) {
        this.potionLogic = potionLogic;
    }

    @Override
    public void event(Player player) {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance <20){
            int option;
            Scanner input = new Scanner(System.in);
            System.out.println("You encounter a bench it seem cozy");
            System.out.println("What you want to do?");
            System.out.println("1. Sit");
            System.out.println("2. Continue walking");
            option = input.nextInt();
            if (option == 1){
                System.out.println("You sit in the bench");
                System.out.println("You started to feel relaxed");
                potionLogic.updatePotions(player);
                double hpRestored = 50 + player.getHp();
                if (hpRestored >= player.getMaximumHP()){
                    player.setHp(player.getMaximumHP());
                } else {
                    player.setHp(hpRestored);
                }
                System.out.println("Your HP was restored");
            }
        }
    }
}
