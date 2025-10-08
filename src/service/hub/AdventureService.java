package service.hub;

import controller.GameLoop;
import interfaces.AreaInterface;
import model.Player;
import service.hub.zones.CaveArea;
import service.hub.zones.ForestArea;


public class AdventureService {

    public void forestArea(Player player) throws InterruptedException {
        AreaInterface forest = new ForestArea();
        GameLoop gameLoop = new GameLoop(player, forest);
        gameLoop.explore();
    }
    public void caveArea(Player player) throws InterruptedException {
        AreaInterface cave = new CaveArea();
        GameLoop gameLoop = new GameLoop(player, cave);
        gameLoop.explore();
    }
}
