package GameEngine;

import Pokemon.Pokemon;

public class Battle {

    private Player player;

    public Pokemon incomingPokemon_fromTrainer;
    public Pokemon incomingPokemon_wild;

    int amountOfParticipants;
    Pokemon[] rawPokemonArray;
    int amountOfPokemon;
    public Pokemon[] battleArray;

    int highestSpeed;

    private int xp;

    public Battle() {

        amountOfParticipants = 0;
        rawPokemonArray = new Pokemon[amountOfParticipants];

        battleArray = new Pokemon[amountOfParticipants];
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

    public void addToBattleArray(Pokemon pokemon) {

        amountOfPokemon ++;
        Pokemon[] battleArrayClone = new Pokemon[amountOfPokemon];
        for (int i = 0; i < battleArray.length; i++) {
            battleArrayClone[i] = battleArray[i];
        }
        battleArrayClone[amountOfPokemon - 1] = pokemon;
        battleArray = battleArrayClone;
    }

    private int findIndexInBattleArray(Pokemon pokemon) {

        for (int i = 0; i < battleArray.length; i++) {
            if (battleArray[i].hashCode() == pokemon.hashCode()) {
                return i;
            }
        }
        return -1;
    }

    public void removeFromBattleArray(Pokemon pokemon) {

        int index = findIndexInBattleArray(pokemon);

        amountOfPokemon --;
        Pokemon[] battleArrayClone = new Pokemon[amountOfPokemon];

        for (int i = 0; i < index; i++) {
            battleArrayClone[i] = battleArray[i];
        }

        for (int i = index; i < battleArrayClone.length; i++) {
            battleArrayClone[i] = battleArray[i + 1];
        }

        battleArray = battleArrayClone;
    }

    private int findIndexInPlayerArray(Player player) {

        for (int i = 0; i < rawPokemonArray.length; i++) {
            if (rawPokemonArray[i].hashCode() == player.hashCode()) {
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

        highestSpeed = rawPokemonArray[0].getSpd();


        Pokemon pokemon1 = incomingPokemon_wild;
        Pokemon pokemon2 = incomingPokemon_fromTrainer;

        if (pokemon1.getSpd() > pokemon2.getSpd()) {
            if (!pokemon1.isInBattle) {
                addToBattleArray(pokemon1);
                pokemon1.isInBattle = true;
            }
            if (!pokemon2.isInBattle) {
                addToBattleArray(pokemon2);
                pokemon2.isInBattle = true;
            }
        }
        else {
            if (!pokemon2.isInBattle) {
                addToBattleArray(pokemon2);
                pokemon2.isInBattle = true;
            }
            if (!pokemon1.isInBattle) {
                addToBattleArray(pokemon1);
                pokemon1.isInBattle = true;
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean areNpcFainted() {

        for (int i = 0; i < battleArray.length; i++) {
            if (battleArray[i].isNpc) {
                return false;
            }
        }
        return true;
    }

    public void distributeReward() {

        Pokemon currentMon;

        if (areNpcFainted()) {
            for (int i = battleArray.length - 1; i >= 0 && i <= battleArray.length; i++) {
                currentMon = battleArray[i];
                System.out.println(currentMon.getName() + " gained 17 EXP. Points!");
                currentMon.setXp(currentMon.getXp() + 17);
                currentMon.updateLevel();
                currentMon.setStats();

                removeFromBattleArray(currentMon);
                player.isInBattle = false;
                player.selectedPOI.setHasOngoingBattle(false);

                if (battleArray.length == 0) {
                    for (int j = 0; j < rawPokemonArray.length; j++) {
                        rawPokemonArray[j].isInBattle = false;
                        rawPokemonArray[j].setActivePokemon(null);
                    }
                }
            }
        }
    }
}
