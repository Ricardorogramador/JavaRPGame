package DBConnection;

import model.Player;
import model.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {
    DBConnection dbConnection = new DBConnection();
    Connection conn = dbConnection.getConnection();

    public List<Skill> getAllSkills() {
        List<Skill> skills = new ArrayList<>();
        String sql = "SELECT id_skill, name, mana_cost, description, damage, price FROM skills";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Skill skill = new Skill(
                        rs.getInt("id_skill"),
                        rs.getString("name"),
                        rs.getInt("mana_cost"),
                        rs.getInt("damage"),
                        rs.getInt("price"),
                        rs.getString("description")
                );
                skills.add(skill);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return skills;
    }

    public List<Skill> getSkills(int id_player){
        List<Skill> skills = new ArrayList<>();
        try {
            String sqlSkill = "SELECT s.id_skill, s.name, s.mana_cost, s.description, s.damage, s.price " +
                    "FROM skills s " +
                    "JOIN player_skills ps ON s.id_skill = ps.id_skill " +
                    "WHERE ps.id_player = ? AND ps.unlocked = TRUE";
            PreparedStatement psSkill = conn.prepareStatement(sqlSkill);
            psSkill.setInt(1, id_player);
            ResultSet rs = psSkill.executeQuery();
            while (rs.next()){
                Skill skill = new Skill(
                        rs.getInt("id_skill"),
                        rs.getString("name"),
                        rs.getInt("mana_cost"),
                        rs.getInt("damage"),
                        rs.getInt("price"),
                        rs.getString("description")
                );
                skills.add(skill);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return skills;
    }
    public void createSkillRelation(Player player, Skill skill){
        String sql = "INSERT INTO player_skills (id_player, id_skill, unlocked) VALUES (?, ?, TRUE) " +
                "ON CONFLICT (id_player, id_skill) DO UPDATE SET unlocked = TRUE";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, player.getId());
            ps.setInt(2, skill.getId_skill());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setFirstSkill(Player player) {
        int fireballSkillID = 1;
        String sql = "INSERT INTO player_skills (id_player, id_skill, unlocked) VALUES (?, ?, TRUE) " +
                "ON CONFLICT (id_player, id_skill) DO UPDATE SET unlocked = TRUE";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, player.getId());
            ps.setInt(2, fireballSkillID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
