//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        //Player creation
        InitializePlayer creator = new InitializePlayer();
        creator.createPlayer(player);
        creator.initializePlayer(player);
        //GameLoop start
        GameLoop gameLoop = new GameLoop(player);
        gameLoop.gameLoop();
    }
}