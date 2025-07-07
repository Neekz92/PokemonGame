package GameEngine;

import Item.*;

import java.util.Scanner;

public class Inventory {

    Player player;

    Scanner scanner;

    int amountOfItems;
    Item[] itemArray;

    public Inventory() {

        scanner = new Scanner(System.in);

        amountOfItems = 0;
        itemArray = new Item[amountOfItems];
    }

    public void addItem(Item item) {

        if (!contains(item)) {
            amountOfItems++;
            Item[] itemArrayClone = new Item[amountOfItems];
            for (int i = 0; i < itemArray.length; i++) {
                itemArrayClone[i] = itemArray[i];
            }
            itemArrayClone[amountOfItems - 1] = item;
            itemArray = itemArrayClone;
            item.setAmount(item.getAmount() + 1);
            item.setPlayer(player);
//            System.out.println("DEBUG from Inventory.addItem if block " + item.getAmount());
        }

        else {
            for (int i = 0; i < itemArray.length; i++) {
                if (item.getName().equals(itemArray[i].getName())) {
                    itemArray[i].setAmount(itemArray[i].getAmount() + 1);
                }
            }
        }
    }

    public Item[] getInventory() {
        return itemArray;
    }

    public boolean contains(Item item) {

        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i].getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    public void decrease(Item item) {

        for (int i = 0; i < player.inventory.itemArray.length; i++ ) {
            if (player.inventory.itemArray[i].getName().equals(item.getName())) {
                itemArray[i].setAmount(itemArray[i].getAmount() - 1);
            }
        }
    }

    public Item[] getItemArray() {
        return itemArray;
    }

    protected void openInventory() {

        if (itemArray.length == 0) {
            System.out.println("You have no items!");
            System.out.println("");
            player.gameEngine.standardTurn();
            return;
        }

        System.out.println("=================================================================");
        for (int i = 0; i < itemArray.length; i++) {
            System.out.println("[ " + (i + 1) + " ] " + itemArray[i].getName() + " x" + itemArray[i].getAmount());
        }
        System.out.println("[ 0 ] EXIT");
        System.out.println("=================================================================");
        System.out.println("");

        selectItemFromInventory();

        if (player.getSelectedItem() != null) {
            player.selectedItem.use();
        }
    }

    public Item selectItemFromInventory() {

        boolean selectItem = true;
        while (selectItem) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input == 0) {
                    player.setSelectedItem(null);
                    selectItem = false;
                    return null;

                }
                player.setSelectedItem(player.inventory.getItemArray()[input - 1]);
                return player.getSelectedItem();
            }
            catch (Exception e) {
                System.out.println("Exception from Inventory.openInventory");
            }
        }
        return player.selectedItem;
    }
}
