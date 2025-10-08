package interfaces;

import model.Monster;
import model.Player;

public interface AreaInterface {
    Monster generatorMonster(Player player, int chance);

    boolean isRestEvent(int chance);

    default String getName() {
        return "Unknown";
    }
}
