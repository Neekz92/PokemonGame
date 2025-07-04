package POIs;

import GameEngine.GameEngine;

public class ViridianCityPokeCenter extends POI {

    public ViridianCityPokeCenter(GameEngine gameEngine) {

        super(gameEngine);
        setName("POKeCENTER");
    }

    @Override
    public void execute() {

        System.out.println("Welcome to our POKeMON CENTER!");
        GameEngine.delay(750);
        System.out.println("We heal your POKeMON back to");
        GameEngine.delay(750);
        System.out.println("perfect health!");
        GameEngine.delay(750);
        System.out.println("Shall we heal your POKeMON?");
        System.out.println("");

        System.out.println("*************************");
        System.out.println("[ 1 ] HEAL");
        System.out.println("[ 2 ] CANCEL");
        System.out.println("*************************");

        boolean healChoice = true;
        while(healChoice) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch(input) {
                    case 1:
                        System.out.println("OK. We'll need your POKeMON.");
                        GameEngine.delay(750);
                        System.out.println("...");
                        GameEngine.delay(3000);
                        System.out.println("Thank you! Your pokemon are");
                        GameEngine.delay(750);
                        System.out.println("fighting fit!");

                        for (int i = 0; i < gameEngine.getPlayer().team.length; i++) {
                            gameEngine.getPlayer().team[i].restore();
                        }

                        healChoice = false;
                        break;

                    case 2:
                        healChoice = false;
                }
            }
            catch(Exception e) {
                System.out.println("Invalid. Exception located at: ViridianCityPokeCenter.execute()");
            }
        }

    }
}
