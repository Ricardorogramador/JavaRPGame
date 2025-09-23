public abstract class Entity {
    private String name;
    private double hp;
    private double defense;
    private double attack;
    private int strength;
    private int intelligence;
    private int wisdom;
    private int lucky;

    public Entity() {
    }

    public Entity(String name, double hp, double defense, double attack, int strength, int intelligence, int wisdom, int lucky) {
        this.name = name;
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
        this.strength = strength;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.lucky = lucky;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getLucky() {
        return lucky;
    }

    public void setLucky(int lucky) {
        this.lucky = lucky;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", lucky=" + lucky +
                '}';
    }
    abstract String mostrarInformacion();
}
