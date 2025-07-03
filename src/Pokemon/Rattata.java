package Pokemon;

import GameEngine.GameEngine;

public class Rattata extends Pokemon {

    public Rattata(GameEngine gameEngine, int level) {

        super(gameEngine, level);

        species = "RATTATA";
        setName(species);
        setType("Normal");

        setBaseHp(30);
        setBaseAtk(56);
        setBaseDef(35);
        setBaseSpatk(25);
        setBaseSpdef(35);
        setBaseSpd(72);

        setStats();
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
