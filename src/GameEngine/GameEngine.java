package GameEngine;

import Locations.*;

import java.util.Scanner;

public class GameEngine {

    Scanner scanner;

    Map map;
    Player currentPlayer;
    int amountOfPlayers;
    Player[] playerArray;

    public GameEngine() {

        scanner = new Scanner(System.in);

        map = new Map(this);

        amountOfPlayers = 0;
        playerArray = new Player[amountOfPlayers];
    }

    public Player getPlayer() {
        return currentPlayer;
    }

    public void addPlayer(Player player) {

        amountOfPlayers ++;
        Player[] playerArrayClone = new Player[amountOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfPlayers - 1] = player;
        playerArray = playerArrayClone;
    }

    public void startGame() {

        Player newPlayer = new Player(this);
        currentPlayer = newPlayer;
        currentPlayer.setIsNpc(false);
        System.out.println("DEBUG from GameEngine.startGame() " + currentPlayer.getName() + " hash: " + currentPlayer.hashCode() + " set NPC flag to FALSE");

        System.out.println("Professor Oak: \"Hello there! Welcome to the world of POKeMON!\"");
        GameEngine.delay(500);
        System.out.println("Professor Oak: \"My name is OAK! People call me the POKeMON PROF!\"");
        GameEngine.delay(500);
        System.out.println("Professor Oak: \"This world is inhabited by creatures called POKeMON!\"");
        GameEngine.delay(500);
        System.out.println("Professor Oak: \"For some people, POKeMON are pets. Others use them for fights.\"");
        GameEngine.delay(500);
        System.out.println("Professor Oak: \"Myself...\"");
        GameEngine.delay(500);
        System.out.println("Professor Oak: \"I study POKeMON as a profession.\"");
        GameEngine.delay(500);
        System.out.println("");
        System.out.println("Professor Oak: \"First, what is your name?\"");

        String name = CreateCharacter.inputName();
        currentPlayer.setName(name);
        currentPlayer.setLocation(map.findLocation(currentPlayer));
        addPlayer(currentPlayer);

        System.out.println("Professor Oak: \"Right! So your name is " + name + "!\"");
        GameEngine.delay(500);
        System.out.println("Professor Oak: \"Your very own POKeMON legend is about to unfold!\"");
        GameEngine.delay(500);
        System.out.println("Professor Oak: \"A world full of dreams and adventures with POKeMON await!\"");
        GameEngine.delay(500);
        System.out.println("Professor Oak: \"Let's go!\"");
        System.out.println("");

    }

    public void turnOrder() {

        boolean gameOn = true;
        while (gameOn) {
            for (int i = 0; i < amountOfPlayers; i++) {
                currentPlayer = playerArray[i];
                if (!currentPlayer.isInBattle) {

                    currentPlayer.gameEngine.standardTurn();
                }

                else {
                    currentPlayer.battle();
                }
            }
            map.battle();
        }
    }

    private void displayStandardTurn() {
        System.out.println("****************************************************************");
        System.out.println(currentPlayer + " is in [ " + currentPlayer.getLocation() + " ]");
        System.out.println("****************************************************************");
        System.out.println("");
        System.out.println("[ 1 ] Travel North");
        System.out.println("[ 2 ] Travel East");
        System.out.println("[ 3 ] Travel South");
        System.out.println("[ 4 ] Travel West");
        System.out.println("[ 5 ] Stay Here");
        System.out.println("[ 6 ] Start Menu");
        System.out.println("[ 7 ] NEW PLAYER");
    }

    protected void standardTurn() {

        displayStandardTurn();
        map.getPalletTown().updateHouseName();

        boolean standardTurn = true;
        while (standardTurn) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                        moveNorth();
                        standardTurn = false;
                        break;
                    case 2:
                        moveEast();
                        standardTurn = false;
                        break;
                    case 3:
                        moveSouth();
                        standardTurn = false;
                        break;
                    case 4:
                        moveWest();
                        standardTurn = false;
                        break;
                    case 5: stayHere(); standardTurn = false; break;
                    case 6: currentPlayer.startMenu(); standardTurn = false; break;
                    case 7: startGame(); standardTurn = false; break;
                    default: System.out.println("Was that a typo?"); break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid." + e);
                scanner.nextLine();
            }
        }
    }

    private void moveNorth() {

        if (currentPlayer.getLocation().getCanMoveNorth()) {

            if (currentPlayer.getLocation().playerArray.length > 0) {
                currentPlayer.getLocation().remove(currentPlayer);
            }

            currentPlayer.setY(currentPlayer.getY() + 1);
            currentPlayer.setLocation(map.findLocation(currentPlayer));
            currentPlayer.getLocation().add(currentPlayer);
            System.out.println("****************************************************************");
            System.out.println(currentPlayer.getName() + " moved north to " + currentPlayer.getLocation().getName());
            System.out.println("****************************************************************");
            System.out.println("");
            activateLocation();
        }
    }

    private void moveEast() {

        if (currentPlayer.getLocation().getCanMoveEast()) {

            if (currentPlayer.getLocation().playerArray.length > 0) {
                currentPlayer.getLocation().remove(currentPlayer);
            }

            currentPlayer.setX(currentPlayer.getX() + 1);
            currentPlayer.setLocation(map.findLocation(currentPlayer));
            currentPlayer.getLocation().add(currentPlayer);
            System.out.println("****************************************************************");
            System.out.println(currentPlayer.getName() + " moved north to " + currentPlayer.getLocation().getName());
            System.out.println("****************************************************************");
            activateLocation();
        }
    }

    private void moveSouth() {

        if (currentPlayer.getLocation().getCanMoveSouth()) {

            if (currentPlayer.getLocation().playerArray.length > 0) {
                currentPlayer.getLocation().remove(currentPlayer);
            }

            currentPlayer.setY(currentPlayer.getY() - 1);
            currentPlayer.setLocation(map.findLocation(currentPlayer));
            currentPlayer.getLocation().add(currentPlayer);
            System.out.println("****************************************************************");
            System.out.println(currentPlayer.getName() + " moved south to " + currentPlayer.getLocation().getName());
            System.out.println("****************************************************************");
            activateLocation();
        }
    }

    private void moveWest() {

        if (currentPlayer.getLocation().getCanMoveWest()) {

            if (currentPlayer.getLocation().playerArray.length > 0) {
                currentPlayer.getLocation().remove(currentPlayer);
            }

            currentPlayer.setX(currentPlayer.getX() - 1);
            currentPlayer.setLocation(map.findLocation(currentPlayer));
            currentPlayer.getLocation().add(currentPlayer);
            System.out.println("****************************************************************");
            System.out.println(currentPlayer.getName() + " moved north to " + currentPlayer.getLocation().getName());
            System.out.println("****************************************************************");
            activateLocation();
        }
    }

    private void stayHere() {
        activateLocation();
    }

    private void activateLocation() {

            System.out.println("These are the points of interest: ");
            currentPlayer.getLocation().showPOI();
            currentPlayer.setSelectedPOI();
            if (currentPlayer.selectedPOI != null) {
                currentPlayer.selectedPOI.execute();
            }

    }

    public static void delay(int delay) {

        try {
            Thread.sleep(delay);  // 1000 ms = 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
