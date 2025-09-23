public class Player extends Entity{
    private String id_player;
    private double xp = 0;
    private int levelPlayer = 1;
    private double maximumXP = 100;
    private boolean alive;

    public Player() {
    }

    public Player(String name, double hp, double defense, double attack, int strength, int intelligence, int wisdom, int lucky, String id_player, double xp, int levelPlayer, double maximumXP) {
        super(name, hp, defense, attack, strength, intelligence, wisdom, lucky);
        this.id_player = id_player;
        this.xp = xp;
        this.levelPlayer = levelPlayer;
        this.maximumXP = maximumXP;
    }

    public Player(String name, double hp, double defense, double attack, int strength, int intelligence, int wisdom, int lucky, String id_player, boolean alive) {
        super(name, hp, defense, attack, strength, intelligence, wisdom, lucky);
        this.id_player = id_player;
        this.alive = alive;
    }

    public String getId_player() {
        return id_player;
    }

    public void setId_player(String id_player) {
        this.id_player = id_player;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public int getLevelPlayer() {
        return levelPlayer;
    }

    public void setLevelPlayer(int levelPlayer) {
        this.levelPlayer = levelPlayer;
    }

    public double getMaximumXP() {
        return maximumXP;
    }

    public void setMaximumXP(double maximumXP) {
        this.maximumXP = maximumXP;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    String mostrarInformacion() {
        return "";
    }
}
