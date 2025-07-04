package Pokemon;

import GameEngine.GameEngine;

public class Oddish extends Pokemon {

    public Oddish(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "ODDISH";
        setName(species);
        setType("Grass");
        setType2("Poison");

        setBaseHp(45);
        setBaseAtk(50);
        setBaseDef(55);
        setBaseSpatk(75);
        setBaseSpdef(65);
        setBaseSpd(30);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(absorb);
            addMoveToLearnSet(growth);
        }

        if (getLevel() >= 4) {
            addMoveToLearnSet(acid);
        }
    }
}
