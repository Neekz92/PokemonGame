package Item;

public class Antidote extends Item {

    public Antidote() {

        setName("ANTIDOTE");
        setBuyPrice(100);
    }

    public Item cloneItem() {
        return new Antidote();
    }
}
