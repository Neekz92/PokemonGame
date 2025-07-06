package Item;

public class Potion extends Item {

    public Potion() {

        setName("POTION");
        setBuyPrice(300);
    }

    public Item cloneItem() {
        return new Potion();
    }
}
