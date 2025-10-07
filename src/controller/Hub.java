package controller;

import model.Player;
import service.hub.InnService;

import java.util.Scanner;

public class Hub {

    public void hub(Player player){
        InnService innService = new InnService();
        System.out.println("Welcome to the Hub.");
        Scanner input = new Scanner(System.in);
        System.out.println("Here you can accept questlines, buy skills and rest");
        while (player.isAlive()){
            int option;
            System.out.println("There is a lot of things to do");
            System.out.println("Select one");
            System.out.println("1. Rest in inn");
            System.out.println("2. Shop");
            System.out.println("3. Adventure guild");
            System.out.println("4. Go out for adventures");
            System.out.println("5. Exit Hub");
            option = input.nextInt();
            switch (option){
                case 1:
                    System.out.println("Welcome to the inn");
                    System.out.println("Select your room.");
                    System.out.println("1. Good room. Price: 80");
                    System.out.println("2. Normal room. Price: 50");
                    System.out.println("3. Bad room. Price: 20");
                    System.out.println("Gold: " + player.getGold());
                    int inn = input.nextInt();
                    if (inn == 1 && player.getGold() >= 80){
                        System.out.println("This is our best room");
                        System.out.println("Have a good rest");
                        innService.goodRoom(player);
                        player.setGold(player.getGold() - 80);
                    } else if (inn == 2 && player.getGold() >= 50) {
                        System.out.println("This room is not our best but can give you a good rest");
                        innService.normalRoom(player);
                        player.setGold(player.getGold() - 50);
                    } else if (inn == 3 && player.getGold() >=20) {
                        System.out.println("The only room you can pay is this one");
                        System.out.println("Is not the best room but you can have rest... I think...");
                        innService.badRoom(player);
                        player.setGold(player.getGold() - 20);
                    } else {
                        System.out.println("You don't have enough gold to pay for a room");
                    }
                    break;
                case 2:
                    //TODO: Here goes shop logic.
                    break;
                case 3:
                    //TODO: Here goes Adventure guild logic or Quest logic.
                    break;
                case 4:
                    //TODO: Here goes adventures logic
                    break;
                case 5:
                    System.out.println("Leaving the Hub");
                    return;
                default:
                    System.out.println("Select a valid option");
            }
        }
    }
}
