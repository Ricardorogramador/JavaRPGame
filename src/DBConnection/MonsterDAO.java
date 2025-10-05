package DBConnection;

import model.Monster;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonsterDAO {
    DBConnection dbConnection = new DBConnection();
    Connection conn = dbConnection.getConnection();

    public List<Monster> getAllMonster(){
        List<Monster> monsters = new ArrayList<>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM monster");
            while (rs.next()){
                Monster monster = new Monster();
                monster.setId_monster(rs.getInt("id_monster"));
                monster.setName(rs.getString("name"));
                monster.setLevelMonster(rs.getInt("levelmonster"));
                monster.setGiveXP(rs.getDouble("givexp"));
                monster.setAttack(rs.getDouble("attack"));
                monster.setDefense(rs.getDouble("defense"));
                monster.setHp(rs.getDouble("hp"));
                monster.setStrength(rs.getInt("strength"));
                monster.setIntelligence(rs.getInt("intelligence"));
                monster.setWisdom(rs.getInt("wisdom"));
                monster.setLucky(rs.getInt("lucky"));
                monster.setMana(rs.getDouble("mana"));
                monster.setMaximumMana(rs.getDouble("maximunmana"));
                monsters.add(monster);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return monsters;
    }

    public Monster getMonster(int id){
        String sql = "SELECT * FROM monster WHERE id_monster = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Monster monster = new Monster();
                monster.setId_monster(rs.getInt("id_monster"));
                monster.setName(rs.getString("name"));
                monster.setLevelMonster(rs.getInt("levelmonster"));
                monster.setGiveXP(rs.getDouble("givexp"));
                monster.setAttack(rs.getDouble("attack"));
                monster.setDefense(rs.getDouble("defense"));
                monster.setHp(rs.getDouble("hp"));
                monster.setStrength(rs.getInt("strength"));
                monster.setIntelligence(rs.getInt("intelligence"));
                monster.setWisdom(rs.getInt("wisdom"));
                monster.setLucky(rs.getInt("lucky"));
                monster.setMana(rs.getDouble("mana"));
                monster.setMaximumMana(rs.getDouble("maximunmana"));
                return monster;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
