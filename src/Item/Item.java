package Item;

import GameEngine.Player;
import Pokemon.Pokemon;

public class Item {

    private Player player;

    private String name;
    private int amount;
    private int buyPrice;
    private int sellPrice;
    private Pokemon target;

    public Item() {

    }

    public Item(Item other) {

        this.name = other.name;
        this.sellPrice = other.sellPrice;
        this.player = other.player;
    }

    public Item cloneItem() {
        return new Item(this);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAmount() {

        return amount;
    }

    public void setAmount(int amount) {

        this.amount = amount;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int price) {
        this.buyPrice = price;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int price) {
        this.sellPrice = price;
    }

    public void setTarget(Pokemon pokemon) {
        target = pokemon;
    }

    public void use() {

        System.out.println("DEBUG from Item.use()");
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
