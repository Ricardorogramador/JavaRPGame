import java.util.Random;

public class RandomBattleGenerator {
    Player player = new Player();
    Monster monster = new Monster();


    public Monster randomBattle(Player player) {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 20) {
            if (player.getLevelPlayer() < 5) {
                return new Monster("Wolf", 100, 12, 15, 5, 5, 5, 5, "1", 20, 3);
            } else if (player.getLevelPlayer() < 10) {
                int pick = rand.nextInt(2);
                if (pick == 0) {
                    return new Monster();
                } else {
                    return new Monster();
                }
            } else {
                return new Monster();
            }
        }
        return null;
    }
}
