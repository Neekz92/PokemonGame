import GameEngine.GameEngine;

public class Application {

    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();
        gameEngine.startGame();
        gameEngine.turnOrder();
    }
}
