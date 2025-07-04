package POIs;

import GameEngine.GameEngine;
import Pokemon.Bulbasaur;
import Pokemon.Charmander;
import Pokemon.Pokemon;
import Pokemon.Squirtle;


public class ProfessorOaksLab extends POI {

    public ProfessorOaksLab(GameEngine gameEngine) {

        super(gameEngine);
        setName("Professor Oak's Lab");
    }

    @Override
    public void execute() {

        if (!gameEngine.getPlayer().receivedStarter) {
            System.out.println("Professor Oak: \"Here " + gameEngine.getPlayer().getName() + "!\"");
            GameEngine.delay(500);
            System.out.println("Professor Oak: \"There are 3 POKeMON here!\"");
            GameEngine.delay(500);
            System.out.println("Professor Oak: \"Haha!\"");
            GameEngine.delay(500);
            System.out.println("Professor Oak: \"They are inside the POKE BALLs.\"");
            GameEngine.delay(500);
            System.out.println("Professor Oak: \"When I was young, I was a serious POKeMON trainer!\"");
            GameEngine.delay(500);
            System.out.println("Professor Oak: \"In my old age, I have only 3 left, but you can have one!\"");
            GameEngine.delay(500);
            System.out.println("Professor Oak: \"Choose!\"");
            System.out.println("");

            System.out.println("[ 1 ] BULBASAUR");
            System.out.println("[ 2 ] CHARMANDER");
            System.out.println("[ 3 ] SQUIRTLE");

            boolean selectStarter = true;
            while (selectStarter) {
                try {
                    int input = scanner.nextInt();
                    scanner.nextLine();

                    switch (input) {
                        case 1:
                            System.out.println(gameEngine.getPlayer() + " received a BULBASAUR!");
                            Pokemon bulbasaur = new Bulbasaur(gameEngine,5);
//                            bulbasaur.addMove(Pokemon.growl);
//                            bulbasaur.addMove(Pokemon.tackle);
//                            bulbasaur.addMove(Pokemon.vineWhip);
                            gameEngine.getPlayer().addPokemon(bulbasaur);
                            gameEngine.getPlayer().receivedStarter = true;
                            selectStarter = false;
                            break;
                        case 2:
                            System.out.println(gameEngine.getPlayer() + " received a CHARMANDER!");
                            Pokemon charmander = new Charmander(gameEngine,5);
//                            charmander.addMove(Pokemon.growl);
//                            charmander.addMove(Pokemon.scratch);
//                            charmander.addMove(Pokemon.ember);
                            gameEngine.getPlayer().addPokemon(charmander);
                            gameEngine.getPlayer().receivedStarter = true;
                            selectStarter = false;
                            break;
                        case 3:
                            System.out.println(gameEngine.getPlayer() + " received a SQUIRTLE!");
                            Pokemon squirtle = new Squirtle(gameEngine,5);
//                            squirtle.addMove(Pokemon.tackle);
//                            squirtle.addMove(Pokemon.tailWhip);
//                            squirtle.addMove(Pokemon.waterGun);
                            gameEngine.getPlayer().addPokemon(squirtle);
                            gameEngine.getPlayer().receivedStarter = true;
                            selectStarter = false;
                            break;
                        default:
                            System.out.println("Invalid.");
                    }
                } catch (Exception e) {
                    System.out.println("Something got FUCKED up!!!!" + e);
                }
            }
        }

        else {
            System.out.println("Professor Oak: Did you finish that POKeDEX yet or what? Hurry tf up.");
            return;
        }
    }
}

