import controller.*;
import service.*;
import model.*;
import interfaces.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //model.Player creation
        PlayerCreation playerCreation = new PlayerCreation();
        Player player = playerCreation.creationPlayer();
        //Controller.GameLoop start
        GameLoop gameLoop = new GameLoop(player);
        gameLoop.gameLoop();
    }
}