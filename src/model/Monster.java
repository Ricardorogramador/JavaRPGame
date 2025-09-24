package model;

public class Monster extends Entity {
    private String id_monster;
    private double giveXP;
    private int levelMonster;

    public Monster() {
    }

    public Monster(String name, double hp, double defense, double attack, int strength, int intelligence, int wisdom, int lucky, String id_monster, double giveXP, int levelMonster) {
        super(name, hp, defense, attack, strength, intelligence, wisdom, lucky);
        this.id_monster = id_monster;
        this.giveXP = giveXP;
        this.levelMonster = levelMonster;
    }

    public String getId_monster() {
        return id_monster;
    }

    public void setId_monster(String id_monster) {
        this.id_monster = id_monster;
    }

    public double getGiveXP() {
        return giveXP;
    }

    public void setGiveXP(double giveXP) {
        this.giveXP = giveXP;
    }

    public int getLevelMonster() {
        return levelMonster;
    }

    public void setLevelMonster(int levelMonster) {
        this.levelMonster = levelMonster;
    }

    @Override
    String mostrarInformacion() {
        return "";
    }
}
