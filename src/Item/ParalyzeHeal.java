package Item;

public class ParalyzeHeal extends Item {

    public ParalyzeHeal() {

        setName("PARALYZ HEAL");
        setBuyPrice(200);
    }

    public Item cloneItem() {
        return new ParalyzeHeal();
    }
}
