import java.time.LocalDate;

public class Battle {
    private String id_battle;
    private LocalDate date = LocalDate.now();
    private String result;
    private double xpGained;
    private Player player;
    private Monster monster;

    public Battle() {
    }

    public Battle(String id_battle, LocalDate date, String result, double xpGained, Player player, Monster monster) {
        this.id_battle = id_battle;
        this.date = date;
        this.result = result;
        this.xpGained = xpGained;
        this.player = player;
        this.monster = monster;
    }

    public String getId_battle() {
        return id_battle;
    }

    public void setId_battle(String id_battle) {
        this.id_battle = id_battle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getXpGained() {
        return xpGained;
    }

    public void setXpGained(double xpGained) {
        this.xpGained = xpGained;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public String toString() {
        return "battle{" +
                "id_battle='" + id_battle + '\'' +
                ", date=" + date +
                ", result='" + result + '\'' +
                ", xpGained=" + xpGained +
                ", player=" + player +
                ", monster=" + monster +
                '}';
    }
}
