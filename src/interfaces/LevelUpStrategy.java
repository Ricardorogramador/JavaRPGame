package interfaces;

import model.Monster;
import model.Player;

public interface LevelUpStrategy {
    void levelUp(Player player, Monster monster);
}
