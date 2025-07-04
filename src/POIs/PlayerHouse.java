package POIs;

import GameEngine.GameEngine;

public class PlayerHouse extends POI {

    public PlayerHouse(GameEngine gameEngine) {

        super(gameEngine);
        setName("PLAYER'S House");
    }

    @Override
    public void execute() {

        if (!gameEngine.getPlayer().receivedStarter) {
            System.out.println("MOM: \"Right.\"");
            GameEngine.delay(500);
            System.out.println("MOM: \"All boys leave home some day.\"");
            GameEngine.delay(500);
            System.out.println("MOM: \"It said so on TV.\"");
            GameEngine.delay(500);
            System.out.println("MOM: \"PROF. OAK, next door,");
            GameEngine.delay(500);
            System.out.println("MOM: \"is looking for you.\"");
            System.out.println("");
        }

        else {
            System.out.println("MOM: \"" + gameEngine.getPlayer() + "! You should take a quick rest.\"");
            GameEngine.delay(1000);
            System.out.println("MOM: \"Oh good! You and your POKeMON are looking great!\"");
            GameEngine.delay(500);
            System.out.println("MOM: \"Take care now!\"");

            for (int i = 0; i < gameEngine.getPlayer().team.length; i++) {
                gameEngine.getPlayer().team[i].restore();
            }
        }
    }
}
