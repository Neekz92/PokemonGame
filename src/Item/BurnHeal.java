package Item;

public class BurnHeal extends Item {

    public BurnHeal() {

        setName("BURN HEAL");
        setBuyPrice(250);
    }

    public Item cloneItem() {
        return new BurnHeal();
    }
}
