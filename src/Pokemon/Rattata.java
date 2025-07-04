package Pokemon;

import GameEngine.GameEngine;

public class Rattata extends Pokemon {

    public Rattata(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "RATTATA";
        setName(species);
        setType("Normal");

        setBaseHp(30);
        setBaseAtk(56);
        setBaseDef(35);
        setBaseSpatk(25);
        setBaseSpdef(35);
        setBaseSpd(72);

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

        if (getLevel() >= 4) {
            addMoveToLearnSet(quickAttack);
        }
    }
}
