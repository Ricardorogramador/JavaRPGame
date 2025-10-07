package service.hub;

import model.Player;


public class InnService {
    public void goodRoom(Player player){
        player.setHp(player.getMaximumHP());
    }
    public void normalRoom(Player player){
        player.setHp(player.getMaximumHP() * 0.60);
    }
    public void badRoom(Player player){
        player.setHp(player.getMaximumHP() * 0.30);
    }
}
