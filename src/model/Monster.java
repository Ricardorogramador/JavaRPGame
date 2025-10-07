package model;

public class Monster extends Entity {
    private int id_monster;
    private double giveXP;
    private int levelMonster;
    private int gold;

    public Monster() {
    }

    public Monster(String name, double hp, double mana, double maximumMana, double defense, double attack, int strength, int intelligence, int wisdom, int lucky, int id_monster, double giveXP, int levelMonster, int gold) {
        super(name, hp, mana, maximumMana, defense, attack, strength, intelligence, wisdom, lucky);
        this.id_monster = id_monster;
        this.giveXP = giveXP;
        this.levelMonster = levelMonster;
        this.gold = gold;
    }

    public Monster(String name, double hp, double defense, double attack, int strength, int intelligence, int wisdom, int lucky, int id_monster, double giveXP, int levelMonster) {
        super(name, hp, defense, attack, strength, intelligence, wisdom, lucky);
        this.id_monster = id_monster;
        this.giveXP = giveXP;
        this.levelMonster = levelMonster;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getId_monster() {
        return id_monster;
    }

    public void setId_monster(int id_monster) {
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

//    @Override
//    String mostrarInformacion() {
//        return "";
//    }
}
