package GameEngine;

import Locations.Map;

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
        currentPlayer.isNpc = false;

        System.out.println("Professor Oak: \"Hello there! Welcome to the world of POKeMON!\"");
        System.out.println("Professor Oak: \"My name is OAK! People call me the POKeMON PROF!\"");
        System.out.println("Professor Oak: \"This world is inhabited by creatures called POKeMON!\"");
        System.out.println("Professor Oak: \"For some people, POKeMON are pets. Others use them for fights.\"");
        System.out.println("Professor Oak: \"Myself...\"");
        System.out.println("Professor Oak: \"I study POKeMON as a profession.\"");
        System.out.println("");
        System.out.println("Professor Oak: \"First, what is your name?\"");

        String name = CreateCharacter.inputName();
        currentPlayer.setName(name);
        currentPlayer.setLocation(map.findLocation(currentPlayer));
        addPlayer(currentPlayer);

        System.out.println("Professor Oak: \"Right! So your name is " + name + "!\"");
        System.out.println("Professor Oak: \"Your very own POKeMON legend is about to unfold!\"");
        System.out.println("Professor Oak: \"A world full of dreams and adventures with POKeMON await!\"");
        System.out.println("Professor Oak: \"Let's go!\"");
        System.out.println("");

        turnOrder();
    }

    public void turnOrder() {

        boolean gameOn = true;
        while (gameOn) {
            for (int i = 0; i < amountOfPlayers; i++) {
                if (!playerArray[i].isInBattle) {
                    playerArray[i].gameEngine.standardTurn();
                    playerArray[i].gameEngine.activateLocation();
                }
                else {
                    playerArray[i].battle();
                }
            }
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
    }

    protected void standardTurn() {

        displayStandardTurn();

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
                    case 3:
                    case 4:
                    case 5: standardTurn = false; break;
                    case 6: currentPlayer.startMenu(); standardTurn = false; break;
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
        }
    }

    private void activateLocation() {

        for (int i = 0; i < amountOfPlayers; i++) {

            System.out.println("These are the points of interest: ");
            currentPlayer.getLocation().showPOI();
            currentPlayer.setSelectedPOI();
            if (currentPlayer.selectedPOI != null) {
                currentPlayer.selectedPOI.execute();
            }
        }
    }
}
