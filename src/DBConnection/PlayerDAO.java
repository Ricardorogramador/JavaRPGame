package DBConnection;

import model.Player;
import model.Race;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerDAO {
    DBConnection dbConnection = new DBConnection();
    Connection conn = dbConnection.getConnection();

    public List<Player> getAllPlayer(){
        List<Player> players = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM player");
            while (rs.next()){
                Player player = new Player();
                player.setId(rs.getInt("id_player"));
                player.setRace(Race.valueOf(rs.getString("race")));
                player.setName(rs.getString("name"));
                player.setLevelPlayer(rs.getInt("level"));
                player.setStrength(rs.getInt("strength"));
                player.setIntelligence(rs.getInt("intelligence"));
                player.setWisdom(rs.getInt("wisdom"));
                player.setLucky(rs.getInt("lucky"));
                player.setAttack(rs.getDouble("attack"));
                player.setDefense(rs.getDouble("defense"));
                player.setHp(rs.getDouble("hp"));
                player.setMaximumHP(rs.getDouble("maximumhp"));
                player.setMana(rs.getDouble("mana"));
                player.setMaximumMana(rs.getDouble("maximunmana"));
                player.setXp(rs.getDouble("xp"));
                player.setMaximumXP(rs.getDouble("maximumxp"));
                player.setHealthPotion(rs.getInt("healthpotion"));
                player.setManaPotion(rs.getInt("manapotion"));
                player.setAlive(rs.getBoolean("alive"));
                players.add(player);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return players;
    }

    public Player getPlayer(int id){
        String readSQL = "SELECT * FROM player WHERE id_player = ?";
        try {
            PreparedStatement psRead = conn.prepareStatement(readSQL);
            psRead.setInt(1, id);
            ResultSet rs = psRead.executeQuery();
            if (rs.next()){
                Player player = new Player();
                player.setId(rs.getInt("id_player"));
                player.setRace(Race.valueOf(rs.getString("race")));
                player.setName(rs.getString("name"));
                player.setLevelPlayer(rs.getInt("level"));
                player.setStrength(rs.getInt("strength"));
                player.setIntelligence(rs.getInt("intelligence"));
                player.setWisdom(rs.getInt("wisdom"));
                player.setLucky(rs.getInt("lucky"));
                player.setAttack(rs.getDouble("attack"));
                player.setDefense(rs.getDouble("defense"));
                player.setHp(rs.getDouble("hp"));
                player.setMaximumHP(rs.getDouble("maximumhp"));
                player.setMana(rs.getDouble("mana"));
                player.setMaximumMana(rs.getDouble("maximunmana"));
                player.setXp(rs.getDouble("xp"));
                player.setMaximumXP(rs.getDouble("maximumxp"));
                player.setHealthPotion(rs.getInt("healthpotion"));
                player.setManaPotion(rs.getInt("manapotion"));
                player.setAlive(rs.getBoolean("alive"));
                return player;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void createPlayer(Player player){
        int opcion;
        Scanner input = new Scanner(System.in);
        String data;
        try{
            String playerSql = "INSERT INTO player (race,name, level, strength, intelligence, wisdom, lucky, attack" +
                    ", defense, hp, maximumHP, mana, maximunmana, xp, maximumXP, healthpotion, manapotion, alive) " +
                    " VALUES (?::race,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement playerPreparedStatement = conn.prepareStatement(playerSql, Statement.RETURN_GENERATED_KEYS);
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
            //Generate key for id.
            ResultSet rs = playerPreparedStatement.getGeneratedKeys();
            if (rs.next()){
                int generateID = rs.getInt(1);
                player.setId(generateID);
            }
        } catch (SQLException e){
            System.out.println("Error in player creation: " + e.getMessage());
        }
    }

    public void deletePlayer(Player player){
            String deleteSQL = "DELETE FROM player WHERE id_player = ?";
        try {
            PreparedStatement psmtDelete = conn.prepareStatement(deleteSQL);
                psmtDelete.setInt(1, player.getId());
                int rows = psmtDelete.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updatePlayer(Player player){
        String updateSQL = "UPDATE player SET level = ?, strength = ?, intelligence = ?, wisdom = ?," +
                "lucky = ?, attack = ?, defense = ?, hp = ?, maximumhp = ?, mana = ?, maximunmana = ?," +
                "xp = ?, maximumxp = ?, healthpotion = ?, manapotion = ?, alive = ? WHERE id_player = ?";
        try {
            PreparedStatement psUpdate = conn.prepareStatement(updateSQL);
            psUpdate.setInt(1, player.getLevelPlayer());
            psUpdate.setDouble(2, player.getStrength());
            psUpdate.setDouble(3, player.getIntelligence());
            psUpdate.setDouble(4, player.getWisdom());
            psUpdate.setDouble(5, player.getLucky());
            psUpdate.setDouble(6, player.getAttack());
            psUpdate.setDouble(7, player.getDefense());
            psUpdate.setDouble(8, player.getHp());
            psUpdate.setDouble(9, player.getMaximumHP());
            psUpdate.setDouble(10, player.getMana());
            psUpdate.setDouble(11, player.getMaximumMana());
            psUpdate.setDouble(12, player.getXp());
            psUpdate.setDouble(13, player.getMaximumXP());
            psUpdate.setInt(14, player.getHealthPotion());
            psUpdate.setInt(15, player.getManaPotion());
            psUpdate.setBoolean(16, player.isAlive());
            psUpdate.setInt(17, player.getId());
            int rowUpdate = psUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
