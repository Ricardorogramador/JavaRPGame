package model;

public class Player extends Entity {
    private int id;
    private int gold;
    private int healthPotion = 3;
    private int manaPotion = 3;
    private double xp = 0;
    private int levelPlayer = 1;
    private double maximumXP = 100;
    private boolean alive;
    private double maximumHP;
    private Race race;

    public Player() {
    }

    public Player(String name, double hp, double mana, double maximumMana, double defense, double attack, int strength, int intelligence, int wisdom, int lucky, int id, int gold, int healthPotion, int manaPotion, double xp, int levelPlayer, double maximumXP, boolean alive, double maximumHP, Race race) {
        super(name, hp, mana, maximumMana, defense, attack, strength, intelligence, wisdom, lucky);
        this.id = id;
        this.gold = gold;
        this.healthPotion = healthPotion;
        this.manaPotion = manaPotion;
        this.xp = xp;
        this.levelPlayer = levelPlayer;
        this.maximumXP = maximumXP;
        this.alive = alive;
        this.maximumHP = maximumHP;
        this.race = race;
    }

    public Player(String name, double hp, double mana, double maximumMana , double defense, double attack, int strength, int intelligence, int wisdom, int lucky, int id, boolean alive) {
        super(name, hp, mana, maximumMana, defense, attack, strength, intelligence, wisdom, lucky);
        this.id = id;
        this.alive = alive;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getManaPotion() {
        return manaPotion;
    }

    public void setManaPotion(int manaPotion) {
        this.manaPotion = manaPotion;
    }

    public int getHealthPotion() {
        return healthPotion;
    }

    public void setHealthPotion(int healthPotion) {
        this.healthPotion = healthPotion;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getMaximumHP() {
        return maximumHP;
    }

    public void setMaximumHP(double maximumHP) {
        this.maximumHP = maximumHP;
    }

    @Override
    public String toString() {
        return  "Name: " + getName() + "\n" +
                "ID: " + getId() + "\n" +
                "Level: " + getLevelPlayer() + "\n" +
                "HP: " + getHp() + "\n" +
                "Gold: " + getGold() + "\n" +
                "-----------------------------";
    }


    //    @Override
//    String mostrarInformacion() {
//        return "";
//    }
}
