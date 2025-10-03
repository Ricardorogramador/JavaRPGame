package service;

public class DamageCalculator {
    public static double calculateDamage(double attackerAttack, double defenderDefense){
        double damageReduction = defenderDefense / (defenderDefense + 100);
        return attackerAttack * (1 -damageReduction);
    }
}