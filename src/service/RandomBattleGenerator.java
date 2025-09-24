package service;

import model.Monster;
import model.Player;

import java.util.Random;

public class RandomBattleGenerator {
    private double wolfProbability = 0.3; // Probabilidad inicial del lobo (30%)
    private double wolfMinProbability = 0.05; // Probabilidad mínima del lobo

    public Monster randomBattle(Player player) {
        Random rand = new Random();
        int level = player.getLevelPlayer();
        int chance = rand.nextInt(100);

        // Determina si habrá batalla este paso (20%)
        if (chance < 20) {
            // Determina cuál enemigo aparece, según el nivel
            double roll = rand.nextDouble();
            if (level < 5) {
                // Solo puede salir lobo (con probabilidad dinámica), o slime dummy
                if (roll < wolfProbability) {
                    // Sale lobo, baja su probabilidad para la próxima vez
                    wolfProbability = Math.max(wolfProbability - 0.1, wolfMinProbability);
                    return new Monster("Wolf", 100, 12, 15, 5, 5, 5, 5, "1", 20, 3);
                } else {
                    // Sale slime (dummy)
                    wolfProbability = 0.3; // Reinicia la probabilidad del lobo si no sale
                    return new Monster("Slime", 60, 6, 8, 2, 4, 3, 3, "2", 10, 2);
                }
            } else if (level < 10) {
                // Aquí puedes agregar más enemigos
                if (roll < wolfProbability) {
                    wolfProbability = Math.max(wolfProbability - 0.1, wolfMinProbability);
                    return new Monster("Wolf", 120, 14, 17, 6, 7, 7, 6, "1", 25, 4);
                } else if (roll < wolfProbability + 0.2) { // 20% para goblin
                    wolfProbability = 0.3;
                    return new Monster("Goblin", 90, 10, 12, 4, 6, 5, 6, "3", 18, 3);
                } else {
                    wolfProbability = 0.3;
                    return new Monster("Slime", 80, 7, 9, 3, 5, 4, 4, "2", 12, 2);
                }
            } else {
                // Niveles altos: más variedad
                if (roll < wolfProbability) {
                    wolfProbability = Math.max(wolfProbability - 0.1, wolfMinProbability);
                    return new Monster("Wolf", 150, 16, 20, 8, 9, 8, 7, "1", 40, 5);
                } else if (roll < wolfProbability + 0.15) {
                    wolfProbability = 0.3;
                    return new Monster("Goblin", 110, 15, 14, 7, 8, 6, 8, "3", 21, 4);
                } else if (roll < wolfProbability + 0.3) {
                    wolfProbability = 0.3;
                    return new Monster("Orc", 200, 20, 25, 11, 12, 10, 10, "4", 50, 6);
                } else {
                    wolfProbability = 0.3;
                    return new Monster("Slime", 100, 10, 13, 5, 7, 5, 5, "2", 15, 3);
                }
            }
        }
        // Si no hay batalla
        return null;
    }
}