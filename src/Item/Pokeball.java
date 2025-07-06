package Item;

import Moves.ThrowPokeball;

public class Pokeball extends Item {

    public Pokeball() {

        setName("POKe BALL");
        setBuyPrice(200);
    }

    public Item cloneItem() {
        return new Pokeball();
    }

    @Override
    public void use() {

        getPlayer().setSelectedTarget(getPlayer().battle.incomingPokemon_wild);
        getPlayer().getSelectedPokemon().setSelectedMove(new ThrowPokeball());
        //System.out.println(getPlayer().getName() + " throws a POKeBALL");
    }
}
