package DBConnection;

import model.Player;
import model.Quest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestDAO {

    // =====================
    //  Atributos y conexión
    // =====================
    private final DBConnection dbConnection = new DBConnection();
    private final Connection conn = dbConnection.getConnection();

    // =====================
    //  Obtener misiones
    // =====================
    public List<Quest> getAllQuest() {
        List<Quest> quests = new ArrayList<>();

        String sql = """
                SELECT id_quest, questname, questdescription, requiredLevel, 
                       activequest, completedquest, target_name, required_amount, 
                       reward_xp, reward_gold 
                FROM quest
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Quest quest = new Quest(
                        rs.getInt("id_quest"),
                        rs.getString("questname"),
                        rs.getString("questdescription"),
                        rs.getInt("requiredLevel"),
                        rs.getBoolean("activequest"),
                        rs.getBoolean("completedquest"),
                        rs.getString("target_name"),
                        rs.getInt("required_amount"),
                        rs.getDouble("reward_xp"),
                        rs.getInt("reward_gold")
                );
                quests.add(quest);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return quests;
    }

    // =====================
    //  Misiones activas
    // =====================
    public List<Quest> getAssociatedQuest(int id_player) {
        List<Quest> quests = new ArrayList<>();

        String sql = """
                SELECT q.id_quest, q.questname, q.questdescription, q.requiredLevel, 
                       q.activequest, q.completedquest, q.target_name, q.required_amount, 
                       q.reward_xp, q.reward_gold 
                FROM quest q 
                JOIN player_quest pq ON q.id_quest = pq.id_quest 
                WHERE pq.id_player = ? AND pq.activequest = TRUE
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_player);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Quest quest = new Quest(
                            rs.getInt("id_quest"),
                            rs.getString("questname"),
                            rs.getString("questdescription"),
                            rs.getInt("requiredLevel"),
                            rs.getBoolean("activequest"),
                            rs.getBoolean("completedquest"),
                            rs.getString("target_name"),
                            rs.getInt("required_amount"),
                            rs.getDouble("reward_xp"),
                            rs.getInt("reward_gold")
                    );
                    quests.add(quest);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return quests;
    }

    // =====================
    //  Misiones completadas
    // =====================
    public List<Quest> getCompletedQuest(int id_player) {
        List<Quest> quests = new ArrayList<>();

        String sql = """
                SELECT q.id_quest, q.questname, q.questdescription, q.requiredLevel, 
                       q.activequest, q.completedquest, q.target_name, q.required_amount, 
                       q.reward_xp, q.reward_gold 
                FROM quest q 
                JOIN player_quest pq ON q.id_quest = pq.id_quest 
                WHERE pq.id_player = ? AND pq.activequest = FALSE
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_player);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Quest quest = new Quest(
                            rs.getInt("id_quest"),
                            rs.getString("questname"),
                            rs.getString("questdescription"),
                            rs.getInt("requiredLevel"),
                            rs.getBoolean("activequest"),
                            rs.getBoolean("completedquest"),
                            rs.getString("target_name"),
                            rs.getInt("required_amount"),
                            rs.getDouble("reward_xp"),
                            rs.getInt("reward_gold")
                    );
                    quests.add(quest);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return quests;
    }

    // =====================
    //  Crear relación jugador-misión
    // =====================
    public void createQuestRelation(Player player, Quest quest) {
        String sql = """
                INSERT INTO player_quest (id_player, id_quest, activequest, completedquest) 
                VALUES (?, ?, TRUE, FALSE) 
                ON CONFLICT (id_player, id_quest) 
                DO UPDATE SET activequest = TRUE, completedquest = FALSE
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, player.getId());
            ps.setInt(2, quest.getIdQuest());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // =====================
    //  Contar misiones activas
    // =====================
    public int countActiveQuest(int id_player) {
        String sql = "SELECT COUNT(*) FROM player_quest WHERE id_player = ? AND activequest = TRUE";
        int count = 0;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_player);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    // =====================
    //  Completar misión
    // =====================
    public void completedQuest(int id_player, int id_quest) {
        String sql = """
                UPDATE player_quest 
                SET activequest = FALSE, completedquest = TRUE 
                WHERE id_player = ? AND id_quest = ?
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_player);
            ps.setInt(2, id_quest);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // =====================
    //  Incrementar progreso
    // =====================
    public int incrementQuestProgress(int id_player, int id_quest) {
        String sql = """
                UPDATE player_quest 
                SET progress = progress + 1 
                WHERE id_player = ? AND id_quest = ? 
                RETURNING progress
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_player);
            ps.setInt(2, id_quest);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("progress");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}
