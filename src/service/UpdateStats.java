package service;

import model.Player;
import model.Race;

public class UpdateStats {
    public void statsUpdate(Player player){
        if (player.getRace() == Race.Human){
            double hp;
            hp = 100 + (player.getStrength() * 5);
            player.setMaximumHP(hp);
            double attack = 10 + (player.getStrength() * 1.5);
            player.setAttack(attack);
            double defense = 5 + (player.getDefense() * 1.2);
            player.setDefense(defense);
        }
    }
}
