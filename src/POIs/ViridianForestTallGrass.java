package POIs;

import GameEngine.*;
import Pokemon.*;


public class ViridianForestTallGrass extends POI {

    public ViridianForestTallGrass(GameEngine gameEngine) {

        super(gameEngine);
        setName("Viridian Forest");
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

        int rng1 = random.nextInt(1, 5);
        int rng2;
        switch (rng1) {
            case 1: rng2 = 57; break;
            case 2: rng2 = 96; break;
            case 3: rng2 = 135; break;
            case 4: rng2 = 179; break;
            default: rng2 = 0;
        }



        Pokemon caterpie = new Caterpie(gameEngine, rng2);
        Pokemon weedle = new Weedle(gameEngine, rng2);
        Pokemon pidgey = new Pidgey(gameEngine, rng2);


        Pokemon oddish = new Oddish(gameEngine, rng2);
        Pokemon bellsprout = new Bellsprout(gameEngine, rng2);
        Pokemon pikachu = new Pikachu(gameEngine, rng2);


        int rngEncounter = random.nextInt(1, 100);
        if (rngEncounter <= 30) {
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

        else if (rngEncounter <= 50) {
            System.out.println("A wild " + pikachu + " has appeared!");
            pikachu.setLocation(player.getLocation());
            battle.addToRawPokemonArray(pikachu);
            battle.incomingPokemon_wild = pikachu;
            pikachu.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 60) {
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

        else if (rngEncounter <= 70) {
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

        else if (rngEncounter <= 85) {
            System.out.println("A wild " + caterpie + " has appeared!");
            caterpie.setLocation(player.getLocation());
            battle.addToRawPokemonArray(caterpie);
            battle.incomingPokemon_wild = caterpie;
            caterpie.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

            gameEngine.turnOrder();
        }

        else {
            System.out.println("A wild " + weedle + " has appeared!");
            weedle.setLocation(player.getLocation());
            battle.addToRawPokemonArray(weedle);
            battle.incomingPokemon_wild = weedle;
            weedle.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

            gameEngine.turnOrder();
        }
    }
}
