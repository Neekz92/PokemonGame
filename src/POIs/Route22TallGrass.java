package POIs;

import GameEngine.Battle;
import GameEngine.GameEngine;
import Pokemon.*;

public class Route22TallGrass extends POI {

    public Route22TallGrass(GameEngine gameEngine) {

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
            battle.playerArray.add(player);

            player.setSelectedPokemon(player.team[0]);
            battle.addToRawPokemonArray(player.getSelectedPokemon());
            battle.incomingPokemon_fromTrainer1 = player.getSelectedPokemon();
            player.setActivePokemon(player.getSelectedPokemon());
            player.getActivePokemon().battle = battle;
            player.getActivePokemon().isInBattle = true;

            wildEncounterSetup();
            player.battle();
        }

        else if (!battle.contains(gameEngine.getPlayer())) {
            player = gameEngine.getPlayer();
            player.isInBattle = true;
            player.battle = battle;
            player.getLocation().poi = this;
            battle.setPlayer(player);
            battle.playerArray.add(player);

            player.setSelectedPokemon(player.team[0]);
            battle.addToRawPokemonArray(player.getSelectedPokemon());
            battle.getIncomingPokemon_fromTrainer2 = player.getSelectedPokemon();
            player.setActivePokemon(player.getSelectedPokemon());
            player.getActivePokemon().battle = battle;
            player.getActivePokemon().isInBattle = true;
            player.battle();

            System.out.println(player.team[0].getName() + " has joined the battle!");
        }
    }

    public void wildEncounterSetup() {

        int rng1 = random.nextInt(1, 3);
        int rng2;
        switch (rng1) {
            case 1:
                rng2 = 57;
                break;
            case 2:
                rng2 = 97;
                break;
            default:
                rng2 = 0;
        }

        Pokemon rattata = new Rattata(gameEngine, rng2);
        Pokemon spearow = new Spearow(gameEngine, rng2);
        Pokemon nidoranF = new NidoranF(gameEngine, rng2);
        Pokemon nidoranM = new NidoranM(gameEngine, rng2);

        int rngEncounter = random.nextInt(1, 101);
        if (rngEncounter <= 30) {
            System.out.println("A wild " + rattata + " has appeared!");
            rattata.setLocation(player.getLocation());
            battle.addToRawPokemonArray(rattata);
            battle.incomingPokemon_wild = rattata;
            rattata.battle = battle;
            rattata.isInBattle = true;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        } else if (rngEncounter <= 60) {
            System.out.println("A wild " + spearow + " has appeared!");
            spearow.setLocation(player.getLocation());
            battle.addToRawPokemonArray(spearow);
            battle.incomingPokemon_wild = spearow;
            spearow.battle = battle;
            spearow.isInBattle = true;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        } else if (rngEncounter <= 80) {
            System.out.println("A wild " + nidoranF + " has appeared!");
            nidoranF.setLocation(player.getLocation());
            battle.addToRawPokemonArray(nidoranF);
            battle.incomingPokemon_wild = nidoranF;
            nidoranF.battle = battle;
            nidoranF.isInBattle = true;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();

        } else if (rngEncounter <= 100) {
            System.out.println("A wild " + nidoranM + " has appeared!");
            nidoranM.setLocation(player.getLocation());
            battle.addToRawPokemonArray(nidoranM);
            battle.incomingPokemon_wild = nidoranM;
            nidoranM.battle = battle;
            nidoranM.isInBattle = true;

            System.out.println("Go! " + player.getSelectedPokemon() + "!");
            System.out.println("");
            System.out.println("");

//            gameEngine.turnOrder();
        }
    }
}
