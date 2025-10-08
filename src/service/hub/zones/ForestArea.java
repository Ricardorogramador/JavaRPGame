package service.hub.zones;

import interfaces.AreaInterface;
import model.Monster;
import model.Player;
import service.battle.RandomBattleGenerator;

public class ForestArea implements AreaInterface {
    private final RandomBattleGenerator generator = new RandomBattleGenerator();
    @Override
    public Monster generatorMonster(Player player, int chance) {
        if (chance <=40){
            return generator.randomBattleForest(player);
        }
        return null;
    }

    @Override
    public boolean isRestEvent(int chance) {
        return chance > 40 && chance <= 70;
    }

    @Override
    public String getName() {
        return "Forest";
    }
}
