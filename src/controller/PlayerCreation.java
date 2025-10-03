package controller;

import DBConnection.PlayerDAO;
import model.Player;
import service.InitializePlayer;

import java.util.List;
import java.util.Scanner;

public class PlayerCreation {
    PlayerDAO playerDAO = new PlayerDAO();
    InitializePlayer initializePlayer = new InitializePlayer();
    public Player creationPlayer() {
        Player player = new Player();
        Scanner input = new Scanner(System.in);
        List<Player> players = playerDAO.getAllPlayer();
        if (players.isEmpty()) {
            System.out.println("There is no player in the Database, create a new one");
            initializePlayer.createPlayer(player);
            initializePlayer.initializePlayer(player);
            return player;
        }
        System.out.println("You have players created, they will appear here:");
        for (Player p : players) {
            System.out.println(p);
        }
        Player selectedPlayer = null;
        while (selectedPlayer == null) {
            System.out.println("Select the ID of your player");
            int option = input.nextInt();
            selectedPlayer = playerDAO.getPlayer(option);
            if (selectedPlayer == null) {
                System.out.println("There is no player with the ID introduced");
            } else {
                System.out.println("You selected: " + selectedPlayer.getName());
                player = selectedPlayer;
            }
        }
        return player;
    }
}
