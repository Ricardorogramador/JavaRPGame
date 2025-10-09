package model;

public class Skill {
    private int id_skill;
    private String name;
    private int manaCost;
    private double magicDamage;
    private int price;
    private String description;

    public Skill() {
    }


    public Skill(int id_skill, String name, int manaCost, double magicDamage, int price, String description) {
        this.id_skill = id_skill;
        this.name = name;
        this.manaCost = manaCost;
        this.magicDamage = magicDamage;
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(double magicDamage) {
        this.magicDamage = magicDamage;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
