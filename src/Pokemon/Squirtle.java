package Pokemon;

import GameEngine.GameEngine;

public class Squirtle extends Pokemon {

    public Squirtle(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "SQUIRTLE";
        setName(species);
        setType("Water");

        setBaseHp(44);
        setBaseAtk(48);
        setBaseDef(65);
        setBaseSpatk(50);
        setBaseSpdef(64);
        setBaseSpd(43);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(tackle);
            addMoveToLearnSet(tailWhip);
        }

        if (getLevel() >= 3) {
            addMoveToLearnSet(waterGun);
        }
    }
}