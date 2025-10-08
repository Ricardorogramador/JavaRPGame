package service.battle;

import DBConnection.MonsterDAO;
import model.Monster;
import model.Player;

import java.util.Random;

public class RandomBattleGenerator {

    Random rand = new Random();
    public Monster randomBattleForest(Player player) {
        MonsterDAO monsterDAO = new MonsterDAO();
        int chance = rand.nextInt(100) +1;
        Monster monster = null;
        if (player.getLevelPlayer() < 6){
            if (chance <= 50){
                int id = rand.nextInt(3) + 1;
                monster =monsterDAO.getMonster(id);
            } else if (chance <=80){
                int id = rand.nextInt(6- 4 +1) + 4;
               monster = monsterDAO.getMonster(id);
            } else if (chance <= 95){
                int id = rand.nextInt(9 - 7 + 1) + 7;
              monster =  monsterDAO.getMonster(id);
            } else {
               monster = monsterDAO.getMonster(10);
            }
        }
        return monster;
    }
    public Monster randomBattleCave(Player player){
        MonsterDAO monsterDAO = new MonsterDAO();
        int chance = rand.nextInt(100) +1;
        Monster monster = null;
        if (player.getLevelPlayer() < 6){
            if (chance <= 50){
                int id = rand.nextInt(3) + 1;
                monster =monsterDAO.getMonster(id);
            } else if (chance <=80){
                int id = rand.nextInt(6- 4 +1) + 4;
                monster = monsterDAO.getMonster(id);
            } else if (chance <= 95){
                int id = rand.nextInt(9 - 7 + 1) + 7;
                monster =  monsterDAO.getMonster(id);
            } else {
                monster = monsterDAO.getMonster(10);
            }
        }
        return monster;
    }
}