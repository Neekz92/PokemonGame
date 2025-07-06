package GameEngine;

import Item.*;

public class Inventory {

    Player player;

    int amountOfItems;
    Item[] itemArray;

    public Inventory() {

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

    private boolean contains(Item item) {

        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i].getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
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
        GameEngine.delay(1000);
//        player.gameEngine.standardTurn();
    }
}
