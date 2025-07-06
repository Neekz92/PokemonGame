package POIs;

import GameEngine.*;
import Pokemon.*;


public class ViridianForestTallGrass extends POI {

    public ViridianForestTallGrass(GameEngine gameEngine) {

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
            battle.incomingPokemon_fromTrainer1 = player.getSelectedPokemon();
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
        Pokemon metapod = new Metapod(gameEngine, rng2);
        Pokemon butterfree = new Butterfree(gameEngine, rng2);
        Pokemon kakuna = new Kakuna(gameEngine, rng2);
        Pokemon beedrill = new Beedrill(gameEngine, rng2);
        Pokemon oddish = new Oddish(gameEngine, rng2);
        Pokemon bellsprout = new Bellsprout(gameEngine, rng2);
        Pokemon pikachu = new Pikachu(gameEngine, rng2);

        Pokemon bulbasaur = new Bulbasaur(gameEngine, rng2);


        int rngEncounter = random.nextInt(1, 101);

        if (rngEncounter <= 23) {
            System.out.println("A wild " + caterpie + " has appeared!");
            caterpie.setLocation(player.getLocation());
            battle.addToRawPokemonArray(caterpie);
            battle.incomingPokemon_wild = caterpie;
            caterpie.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 47) {
            System.out.println("A wild " + weedle + " has appeared!");
            weedle.setLocation(player.getLocation());
            battle.addToRawPokemonArray(weedle);
            battle.incomingPokemon_wild = weedle;
            weedle.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }


        else if (rngEncounter <= 62) {
            System.out.println("A wild " + pidgey + " has appeared!");
            pidgey.setLocation(player.getLocation());
            battle.addToRawPokemonArray(pidgey);
            battle.incomingPokemon_wild = pidgey;
            pidgey.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 72) {
            System.out.println("A wild " + metapod + " has appeared!");
            metapod.setLocation(player.getLocation());
            battle.addToRawPokemonArray(metapod);
            battle.incomingPokemon_wild = metapod;
            metapod.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 82) {
            System.out.println("A wild " + kakuna + " has appeared!");
            kakuna.setLocation(player.getLocation());
            battle.addToRawPokemonArray(kakuna);
            battle.incomingPokemon_wild = kakuna;
            kakuna.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 87) {
            System.out.println("A wild " + oddish + " has appeared!");
            oddish.setLocation(player.getLocation());
            battle.addToRawPokemonArray(oddish);
            battle.incomingPokemon_wild = oddish;
            oddish.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 92) {
            System.out.println("A wild " + bellsprout + " has appeared!");
            bellsprout.setLocation(player.getLocation());
            battle.addToRawPokemonArray(bellsprout);
            battle.incomingPokemon_wild = bellsprout;
            bellsprout.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 97) {
            System.out.println("A wild " + pikachu + " has appeared!");
            pikachu.setLocation(player.getLocation());
            battle.addToRawPokemonArray(pikachu);
            battle.incomingPokemon_wild = pikachu;
            pikachu.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 98) {
            System.out.println("A wild " + butterfree + " has appeared!");
            pikachu.setLocation(player.getLocation());
            battle.addToRawPokemonArray(pikachu);
            battle.incomingPokemon_wild = pikachu;
            pikachu.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else if (rngEncounter <= 99) {
            System.out.println("A wild " + beedrill + " has appeared!");
            beedrill.setLocation(player.getLocation());
            battle.addToRawPokemonArray(beedrill);
            battle.incomingPokemon_wild = beedrill;
            beedrill.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }

        else {
            System.out.println("A wild " + bulbasaur + " has appeared!");
            bulbasaur.setLocation(player.getLocation());
            battle.addToRawPokemonArray(bulbasaur);
            battle.incomingPokemon_wild = bulbasaur;
            bulbasaur.battle = battle;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }
    }
}
