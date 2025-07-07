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

        if (!getPlayer().isInBattle) {
            System.out.println("You can't use that here.");
            System.out.println("");
            return;
        }

        else {

            if (getPlayer().getInventory().contains(this)) {
                getPlayer().getInventory().decrease(this);
                getPlayer().setSelectedTarget(getPlayer().battle.incomingPokemon_wild);
                ThrowPokeball pokeball = new ThrowPokeball();
                pokeball.setPlayer(getPlayer());
                getPlayer().getSelectedPokemon().setSelectedMove(pokeball);
            }
        }
    }
}
