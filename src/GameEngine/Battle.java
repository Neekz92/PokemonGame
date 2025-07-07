package GameEngine;

import Moves.Move;
import Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {

    Random random;

    private Player player;
    public List<Player> playerArray;

    Pokemon currentMon;

    public Pokemon incomingPokemon_fromTrainer1;
    public Pokemon getIncomingPokemon_fromTrainer2;

    public Pokemon incomingPokemon_wild;

    int amountOfParticipants;
    Pokemon[] rawPokemonArray;

    private double rawDamage;

    public Battle() {

        playerArray = new ArrayList<>();

        random = new Random();

        amountOfParticipants = 0;
        rawPokemonArray = new Pokemon[amountOfParticipants];

    }

    public boolean contains(Player player) {

        for (int i = 0; i < rawPokemonArray.length; i++) {
            if (rawPokemonArray[i].hashCode() == player.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public void addToRawPokemonArray(Pokemon pokemon) {

        amountOfParticipants ++;
        Pokemon[] rawPokemonArrayClone = new Pokemon[amountOfParticipants];
        for (int i = 0; i < rawPokemonArray.length; i++) {
            rawPokemonArrayClone[i] = rawPokemonArray[i];
        }
        rawPokemonArrayClone[amountOfParticipants - 1] = pokemon;
        rawPokemonArray = rawPokemonArrayClone;
    }

    private int findIndexInPlayerArray(Pokemon pokemon) {

        for (int i = 0; i < rawPokemonArray.length; i++) {
            if (rawPokemonArray[i].hashCode() == pokemon.hashCode()) {
                return i;
            }
        }
        return -1;
    }

    public void removeFromRawPokemonArray(Pokemon pokemon) {

        int index = findIndexInPlayerArray(pokemon);

        amountOfParticipants --;
        Pokemon[] rawPokemonArrayClone = new Pokemon[amountOfParticipants];

        for (int i = 0; i < index; i++) {
            rawPokemonArrayClone[i] = rawPokemonArray[i];
        }

        for (int i = index; i < rawPokemonArrayClone.length; i++) {
            rawPokemonArrayClone[i] = rawPokemonArray[i + 1];
        }

        rawPokemonArray = rawPokemonArrayClone;
    }

    public void sortBySpeed() {


        // TODO: THIS NEEDS TO BE REFACTORED INTO A SORTING ALGORITHM.
        // I NEED TO CREATE THE BATTLE ARRAY BASED ON THE POKEMON'S SPEED STAT!

        for (int i = 0; i < rawPokemonArray.length - 1; i++) {    //  brute force bubble sort lmao
            if (rawPokemonArray[i].getSpd() < rawPokemonArray[i + 1].getSpd()) {
                Pokemon temp = rawPokemonArray[i];
                rawPokemonArray[i] = rawPokemonArray[i + 1];
                rawPokemonArray[i + 1] = temp;
                i = 0;
            }
        }
//
//        for (int i = 0; i < rawPokemonArray.length; i++) {
//            addToBattleArray(rawPokemonArray[i]);
//        }


//        highestSpeed = rawPokemonArray[0].getSpd();
//
//
//        Pokemon pokemon1 = incomingPokemon_wild;
//        Pokemon pokemon2 = incomingPokemon_fromTrainer1;
//
//        if (pokemon1.getSpd() > pokemon2.getSpd()) {
//            if (!pokemon1.isInBattle) {
//                addToBattleArray(pokemon1);
//                pokemon1.isInBattle = true;
//            }
//            if (!pokemon2.isInBattle) {
//                addToBattleArray(pokemon2);
//                pokemon2.isInBattle = true;
//            }
//        }
//        else {
//            if (!pokemon2.isInBattle) {
//                addToBattleArray(pokemon2);
//                pokemon2.isInBattle = true;
//            }
//            if (!pokemon1.isInBattle) {
//                addToBattleArray(pokemon1);
//                pokemon1.isInBattle = true;
//            }
//        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean areNpcFainted() {

        for (int i = 0; i < rawPokemonArray.length; i++) {
            if (rawPokemonArray[i].isNpc) {
                return false;
            }
        }
        return true;
    }

    public void npcSelectTarget() {

        boolean findTarget = true;
        while (findTarget) {
            int rng = random.nextInt(0, rawPokemonArray.length);

            if (rawPokemonArray[rng].hashCode() != incomingPokemon_wild.hashCode()) {
                incomingPokemon_wild.setSelectedTarget(rawPokemonArray[rng]);
                findTarget = false;
            }
        }
    }

    public Move npcSelectMove() {

        int rng = random.nextInt(0, incomingPokemon_wild.getMoveSet().length);
        incomingPokemon_wild.setSelectedMove(incomingPokemon_wild.getMoveSet()[rng]);

        return incomingPokemon_wild.getSelectedMove();
    }

    public void useMoves() {  //  Damage formula lives here

        sortBySpeed();

        for (int i = 0; i < rawPokemonArray.length; i++) {
            currentMon = rawPokemonArray[i];

            if (currentMon.isInBattle) {

                if (currentMon.ot == null) {  //  npc selects moves
                    npcSelectMove();
                    npcSelectTarget();
                }

                if (currentMon.getSelectedMove() != null && currentMon.getSelectedMove().getName().equals("Pokeball")) {  //  use pokeball
                    System.out.println(currentMon.ot + " throws POKeBALL, but that MF broke free :(");
                    continue;
                }


                System.out.println("");
                if (currentMon.getSelectedMove() != null) {
                    System.out.println("**************************************************");
                    System.out.println(currentMon + " used " + currentMon.getSelectedMove().getName());
                }

                double randomFactor = 0.85 + (Math.random() * 0.15);
                int damagePart1;

                if (currentMon.getCurrentHP() > 0) {
                    if (currentMon.getSelectedMove().getPower() > 0) {
                        rawDamage = ((((2.0 * currentMon.getLevel()) / 5) + 2) * currentMon.getSelectedMove().getPower() * ((double) currentMon.getAtk() / currentMon.getSelectedTarget().getDef()) / 50) + 2;

                        if (currentMon.getType().equals(currentMon.getSelectedMove().getType()) ||
                                (currentMon.getType2() != null && currentMon.getType2().equals(currentMon.getSelectedMove().getType()))) {

                            rawDamage *= 1.5; // STAB!
                        }

                        if (currentMon.getSelectedTarget().weaknesses.contains(currentMon.getSelectedMove().getType())) {
                            System.out.println("It's super effective!");
                            rawDamage *= 2;
                        }

                        if (currentMon.getSelectedTarget().resistances.contains(currentMon.getSelectedMove().getType())) {
                            System.out.println("It's not very effective...");
                            rawDamage *= .5;
                        }


                        rawDamage *= randomFactor;
                        damagePart1 = (int) Math.round(rawDamage);
                    } else {
                        damagePart1 = 0;
                    }

                    currentMon.getSelectedTarget().setCurrentHp(currentMon.getSelectedTarget().getCurrentHP() - damagePart1);
                    System.out.println(currentMon.getSelectedTarget().getName() + " takes " + damagePart1 + " damage. They have: " + currentMon.getSelectedTarget().getCurrentHP() + " hp remaining");

                    System.out.println("**************************************************");
                    System.out.println("");

                    GameEngine.delay(750);

                    faint(currentMon.getSelectedTarget());

                    if (areNpcFainted()) {
                        distributeReward();
                        return;  // exit useMoves() early, stop further moves
                    }
                }
            }
        }
    }

    private void faint(Pokemon pokemon) {

        if (pokemon.getCurrentHP() == 0) {
            System.out.println(pokemon.getName() + " fainted!");
            pokemon.battle.removeFromRawPokemonArray(pokemon);
            distributeReward();
        }
    }

    public void distributeReward() {

        Pokemon currentMon;

        if (areNpcFainted()) {
            for (int i = rawPokemonArray.length - 1; i >= 0 && i <= rawPokemonArray.length; i--) {
                currentMon = rawPokemonArray[i];
                System.out.println(currentMon.getName() + " gained 17 EXP. Points!");
                currentMon.setXp(currentMon.getXp() + 17);
                currentMon.updateLevel();
                currentMon.setStats();
                removeFromRawPokemonArray(currentMon);
            }
        }

        if (areNpcFainted()) {
            for (int i = playerArray.size() - 1; i >= 0; i--) {
                playerArray.get(i).isInBattle = false;
                playerArray.get(i).setActivePokemon(null);
                playerArray.get(i).getLocation().poi.setHasOngoingBattle(false);
                playerArray.remove(i);
            }
        }
    }

    public int getAmountOfNPC() {

        int amountOfNpc = 0;

        for (int i = 0; i < rawPokemonArray.length; i++) {
            if (rawPokemonArray[i].isNpc) {
                amountOfNpc ++;
            }
        }
        return amountOfNpc;
    }

    public int getAmountOfPlayers() {

        int amountOfPlayers = 0;

        for (int i = 0; i < rawPokemonArray.length; i++) {
            if (!rawPokemonArray[i].isNpc) {
                amountOfPlayers ++;
            }
        }
        return amountOfPlayers;
    }
}
