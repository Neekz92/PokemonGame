package Pokemon;

import GameEngine.GameEngine;

public class Spearow extends Pokemon {

    public Spearow(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "SPEAROW";
        setName(species);
        setType("Normal");
        setType2("Flying");

        setBaseHp(40);
        setBaseAtk(60);
        setBaseDef(30);
        setBaseSpatk(31);
        setBaseSpdef(31);
        setBaseSpd(70);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(peck);
            addMoveToLearnSet(tailWhip);
        }

        if (getLevel() >= 4) {
            addMoveToLearnSet(leer);
        }
    }
}
