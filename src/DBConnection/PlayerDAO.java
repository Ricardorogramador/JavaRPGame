package DBConnection;

import model.Player;
import model.Race;

import java.sql.*;
import java.util.Scanner;

public class PlayerDAO {
    DBConnection dbConnection = new DBConnection();
    Connection conn = dbConnection.getConnection();
    Statement statement;

    public void getAllPlayer(){
        try {
            statement = conn.createStatement();
            //Read DataBase.
            ResultSet resultSet = statement.executeQuery("SELECT * FROM player");
            System.out.println(resultSet.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createPlayer(Player player){
        int opcion;
        Scanner input = new Scanner(System.in);
        String data;
        try{
            String playerSql = "INSERT INTO player (race,name, level, strength, intelligence, wisdom, lucky, attack" +
                    ", defense, hp, maximumHP, mana, maximunmana, xp, maximumXP, healthpotion, manapotion, alive) " +
                    " VALUES (?::race,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement playerPreparedStatement = conn.prepareStatement(playerSql);
            System.out.println("---Player creation---");
            System.out.println("Select your race");
            System.out.println("1. Human");
            opcion = input.nextInt();
            if (opcion == 1){
                player.setRace(Race.Human);
            }
            System.out.println("Select your character name");
            data = input.next();
            player.setName(data);
            player.setLevelPlayer(1);
            player.setStrength(0);
            player.setIntelligence(0);
            player.setWisdom(0);
            player.setLucky(0);
            player.setAttack(10);
            player.setDefense(5);
            player.setHp(100);
            player.setMaximumHP(player.getHp());
            player.setMana(50);
            player.setMaximumMana(player.getMana());
            player.setXp(0);
            player.setMaximumXP(100);
            player.setHealthPotion(3);
            player.setManaPotion(3);
            player.setAlive(true);
            playerPreparedStatement.setString(1, player.getRace().name());
            playerPreparedStatement.setString(2, player.getName());
            playerPreparedStatement.setInt(3, player.getLevelPlayer());
            playerPreparedStatement.setInt(4, player.getStrength());
            playerPreparedStatement.setInt(5, player.getIntelligence());
            playerPreparedStatement.setInt(6, player.getWisdom());
            playerPreparedStatement.setInt(7, player.getLucky());
            playerPreparedStatement.setDouble(8, player.getAttack());
            playerPreparedStatement.setDouble(9, player.getDefense());
            playerPreparedStatement.setDouble(10, player.getHp());
            playerPreparedStatement.setDouble(11, player.getMaximumHP());
            playerPreparedStatement.setDouble(12, player.getMana());
            playerPreparedStatement.setDouble(13, player.getMaximumMana());
            playerPreparedStatement.setDouble(14, player.getXp());
            playerPreparedStatement.setDouble(15, player.getMaximumXP());
            playerPreparedStatement.setInt(16, player.getHealthPotion());
            playerPreparedStatement.setInt(17, player.getManaPotion());
            playerPreparedStatement.setBoolean(18, player.isAlive());
            playerPreparedStatement.executeUpdate();
            System.out.println("Your player has been created.");
        } catch (SQLException e){
            System.out.println("Error in player creation: " + e.getMessage());
        }
    }
}
