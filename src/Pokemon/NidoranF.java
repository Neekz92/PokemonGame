package Pokemon;

import GameEngine.GameEngine;

public class NidoranF extends Pokemon {

    public NidoranF(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "NIDORAN♀";
        setName(species);
        setType("Poison");

        weaknesses.add("Ground");
        weaknesses.add("Psychic");

        resistances.add("Grass");
        resistances.add("Fighting");
        resistances.add("Poison");
        resistances.add("Bug");
        resistances.add("Fairy");

        setBaseHp(55);
        setBaseAtk(47);
        setBaseDef(52);
        setBaseSpatk(40);
        setBaseSpdef(40);
        setBaseSpd(41);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(growl);
            addMoveToLearnSet(poisonSting);
        }
    }
}
