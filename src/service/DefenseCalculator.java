package service;

public class DefenseCalculator {
    public static double defenseCalculator(double attackerAttack, double defenderDefense){
        double defenseUp = defenderDefense / (defenderDefense + 150);
        return attackerAttack * (1-defenseUp);
    }
}