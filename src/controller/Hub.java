package controller;

import model.Player;

import java.util.Scanner;

public class Hub {

    public void hub(Player player){
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
                    //TODO: here goes inn logic.
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
