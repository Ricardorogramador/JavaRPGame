package service.hub.zones;

import interfaces.AreaInterface;
import model.Monster;
import model.Player;
import service.battle.RandomBattleGenerator;

public class CaveArea implements AreaInterface {
private final RandomBattleGenerator generator = new RandomBattleGenerator();

    @Override
    public Monster generatorMonster(Player player, int chance) {
        if (chance <= 50){
            return generator.randomBattleCave(player);
        }
        return null;
    }

    @Override
    public boolean isRestEvent(int chance) {
        return chance > 50 && chance <=75;
    }

    @Override
    public String getName() {
        return "Caves";
    }
}
