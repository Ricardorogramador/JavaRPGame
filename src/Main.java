import DBConnection.PlayerDAO;
import controller.*;
import service.player.*;
import service.hub.*;
import service.battle.*;
import service.event.*;
import service.combat.*;
import model.*;
import interfaces.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Do you want to start the game or leave?");
            System.out.println("1. Start the game");
            System.out.println("2. Leave");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    PlayerCreation playerCreation = new PlayerCreation();
                    Player player = playerCreation.creationPlayer();
                    Hub hub = new Hub();
                    hub.hub(player);
                    PlayerDAO playerDAO = new PlayerDAO();
                    playerDAO.updatePlayer(player);
                    break;
                case 2:
                    System.out.println("GoodBye");
                    break;
                default:
                    System.out.println("Invalid option, Try again");
                    break;
            }

        } while (option != 2);

    }
}