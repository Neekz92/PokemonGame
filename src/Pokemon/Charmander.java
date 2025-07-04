package Pokemon;

import GameEngine.GameEngine;

public class Charmander extends Pokemon {

    public Charmander(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "CHARMANDER";
        setName(species);
        setType("Fire");

        setBaseHp(39);
        setBaseAtk(52);
        setBaseDef(43);
        setBaseSpatk(60);
        setBaseSpdef(50);
        setBaseSpd(65);

        updateLevel();
        setStats();
        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(growl);
            addMoveToLearnSet(scratch);
        }

        if (getLevel() >= 4) {
            addMoveToLearnSet(ember);
        }
    }
}
