package POIs;

import GameEngine.*;
import Pokemon.*;

import java.util.Random;
import java.util.Scanner;

public class POI {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    GameEngine gameEngine;
    Player player;

    int amountOfPlayers;
    public Player[] playerArray;

    protected boolean hasOngoingBattle;
    protected Battle battle;

    private String name;

    // constructor lies below
    public POI(GameEngine gameEngine) {

        this.gameEngine = gameEngine;
        amountOfPlayers = 0;
        playerArray = new Player[amountOfPlayers];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void execute() {

    }

    public void setHasOngoingBattle(boolean bool) {
        hasOngoingBattle = bool;
    }

    public Battle getBattle() {
        return battle;
    }

    public void addPokemon(Pokemon pokemon) {

        amountOfPlayers ++;
        Player[] playerArrayClone = new Player[amountOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfPlayers - 1] = pokemon;
        playerArray = playerArrayClone;
    }
}
