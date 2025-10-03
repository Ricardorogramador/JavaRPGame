package DBConnection;

import model.Monster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                monster.setLevelMonster(rs.getInt("levelMonster"));
                monster.setGiveXP(rs.getDouble("giveXP"));
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
}
