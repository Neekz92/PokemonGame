package Locations;

import GameEngine.*;
import POIs.POI;

import java.util.Random;

public class Location {

    GameEngine gameEngine;
    Random random;

    private String name;
    int amountOfPOI;
    public POI[] poiArray;
    public POI poi;

    private int amountOfPlayers;
    public Player[] playerArray;

    protected int x;
    protected int y;

    protected boolean canMoveNorth;
    protected boolean canMoveEast;
    protected boolean canMoveSouth;
    protected boolean canMoveWest;

    public Location(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        random = new Random();

        amountOfPOI = 0;
        poiArray = new POI[amountOfPOI];

        amountOfPlayers = 0;
        playerArray = new Player[amountOfPlayers];
    }

    public void add(Player player) {

        amountOfPlayers ++;
        Player[] playerArrayClone = new Player[amountOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfPlayers - 1] = player;
        playerArray = playerArrayClone;
    }

    public int findIndex(Player player) {

        for (int i = 0; i < playerArray.length; i++) {
            if (player.hashCode() == playerArray[i].hashCode()) {
                return i;
            }
        }
        return -1;
    }

    public void remove(Player player) {

        amountOfPlayers --;
        Player[] playerArrayClone = new Player[amountOfPlayers];
        for (int i = 0; i < findIndex(player); i++) {
            playerArrayClone[i] = playerArray[i];
        }

        for (int i = findIndex(player); i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i + 1];
        }

        playerArray = playerArrayClone;
    }

    public boolean getCanMoveNorth() {
        return canMoveNorth;
    }

    public boolean getCanMoveEast() {
        return canMoveEast;
    }

    public boolean getCanMoveSouth() {
        return canMoveSouth;
    }

    public boolean getCanMoveWest() {
        return canMoveWest;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    protected void addPOI(POI poi) {

        amountOfPOI ++;
        POI[] poiArrayClone = new POI[amountOfPOI];
        for (int i = 0; i < poiArray.length; i++) {
            poiArrayClone[i] = poiArray[i];
        }
        poiArrayClone[amountOfPOI - 1] = poi;
        poiArray = poiArrayClone;
    }

    public void showPOI() {

        for (int i = 0; i < poiArray.length; i++) {
            System.out.println("[ " + (i + 1) + " ] " + poiArray[i].getName());
        }
        System.out.println("[ 0 ] Exit");
    }

    public String toString() {
        return name;
    }
}
