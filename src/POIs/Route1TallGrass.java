package POIs;

import GameEngine.Battle;
import GameEngine.GameEngine;
import Pokemon.*;

public class Route1TallGrass extends POI {

    public Route1TallGrass(GameEngine gameEngine) {

        super(gameEngine);
        setName("Tall Grass");
    }

    public void execute() {

        if (!hasOngoingBattle) {
            battle = new Battle();
            hasOngoingBattle = true;
            player = gameEngine.getPlayer();
            player.isInBattle = true;
            player.battle = battle;
            player.getLocation().poi = this;
            battle.setPlayer(player);

            player.setSelectedPokemon(player.team[0]);
            battle.addToRawPokemonArray(player.getSelectedPokemon());
            battle.incomingPokemon_fromTrainer = player.getSelectedPokemon();
            player.setActivePokemon(player.getSelectedPokemon());

            wildEncounterSetup();
        }
    }

    public void wildEncounterSetup() {

        int rng1 = random.nextInt(1, 3);
        int rng2;
        switch (rng1) {
            case 1: rng2 = 57; break;
            case 2: rng2 = 97; break;
            default: rng2 = 0;
        }



        Pokemon pidgey = new Pidgey(gameEngine, rng2);
        Pokemon rattata = new Rattata(gameEngine, rng2);
        Pokemon oddish = new Oddish(gameEngine, rng2);
        Pokemon bellsprout = new Bellsprout(gameEngine, rng2);

        int rngEncounter = random.nextInt(1, 10);
        if (rngEncounter <= 3) {
            System.out.println("A wild " + pidgey + " has appeared!");
            pidgey.setLocation(player.getLocation());
            battle.addToRawPokemonArray(pidgey);
            battle.incomingPokemon_wild = pidgey;
            pidgey.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 6) {
            System.out.println("A wild " + rattata + " has appeared!");
            rattata.setLocation(player.getLocation());
            battle.addToRawPokemonArray(rattata);
            battle.incomingPokemon_wild = rattata;
            rattata.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 8) {
            System.out.println("A wild " + oddish + " has appeared!");
            oddish.setLocation(player.getLocation());
            battle.addToRawPokemonArray(oddish);
            battle.incomingPokemon_wild = oddish;
            oddish.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

            gameEngine.turnOrder();

        }

        else {
            System.out.println("A wild " + bellsprout + " has appeared!");
            bellsprout.setLocation(player.getLocation());
            battle.addToRawPokemonArray(bellsprout);
            battle.incomingPokemon_wild = bellsprout;
            bellsprout.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

            gameEngine.turnOrder();
        }
    }
}