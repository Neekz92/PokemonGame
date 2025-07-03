package Pokemon;

import GameEngine.GameEngine;

public class Bulbasaur extends Pokemon {

    public Bulbasaur(GameEngine gameEngine, int level) {

        super(gameEngine, level);

        species = "BULBASAUR";
        setName(species);
        setType("Grass");
        setType2("Poison");

        setBaseHp(45);
        setBaseAtk(49);
        setBaseDef(49);
        setBaseSpatk(65);
        setBaseSpdef(65);
        setBaseSpd(45);

        setStats();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(growl);
            addMoveToLearnSet(tackle);
        }

        if (getLevel() >= 3) {
            addMoveToLearnSet(vineWhip);
        }
    }
}
