package POIs;

import GameEngine.*;
import Item.*;
import Pokemon.Pokemon;

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

    protected Item item;
    protected Inventory shop;

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

    public boolean getHighOngoingBattle() {
        return hasOngoingBattle;
    }

    public void setHasOngoingBattle(boolean bool) {
        hasOngoingBattle = bool;
    }

    public Battle getBattle() {
        return battle;
    }

    public void addPokemon(Pokemon pokemon) {

        amountOfPlayers++;
        Player[] playerArrayClone = new Player[amountOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfPlayers - 1] = pokemon;
        playerArray = playerArrayClone;
    }

    protected void showShop() {

        System.out.println("Money: ₽" + gameEngine.getPlayer().getMoney());
        System.out.println("");

        for (int i = 0; i < shop.getInventory().length; i++) {
            System.out.println("[ " + (i + 1) + " ] " + shop.getInventory()[i].getName() + " | Price: ₽" + shop.getInventory()[i].getBuyPrice());
        }
        System.out.println("[ 0 ] EXIT");
    }

    protected void buyItem() {

        boolean buyItem = true;
        while (buyItem) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input == 0) {
                    buyItem = false;
                    return;
                }
                gameEngine.getPlayer().setSelectedItem(shop.getItemArray()[input - 1]);

                if (gameEngine.getPlayer().getMoney() >= gameEngine.getPlayer().getSelectedItem().getBuyPrice()) {
                    Item cloneItem = gameEngine.getPlayer().getSelectedItem().cloneItem();
                    cloneItem.setPlayer(gameEngine.getPlayer());
                    gameEngine.getPlayer().getInventory().addItem(cloneItem);
                    gameEngine.getPlayer().setMoney(gameEngine.getPlayer().getMoney() - gameEngine.getPlayer().getSelectedItem().getBuyPrice());
                    System.out.println("");
                    System.out.println("Here you are. Thank you!");
                    System.out.println("");
                    GameEngine.delay(500);
                }

                else {
                    System.out.println("");
                    System.out.println("You don't have enough money.");
                    System.out.println("");
                    GameEngine.delay(500);
                }

                showShop();
            }

            catch (Exception e) {
                System.out.println(e + " INVALID. From POI.buyItem()");
            }
        }
    }
}
