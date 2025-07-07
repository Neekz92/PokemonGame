package Pokemon;

import GameEngine.GameEngine;

public class Mewtwo extends Pokemon {

    public Mewtwo(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "MEWTWO";
        setName(species);
        setType("Psychic");

        weaknesses.add("Bug");
        weaknesses.add("Ghost");
        weaknesses.add("Dark");

        resistances.add("Fighting");
        resistances.add("Psychic");

        setBaseHp(106);
        setBaseAtk(110);
        setBaseDef(90);
        setBaseSpatk(154);
        setBaseSpdef(90);
        setBaseSpd(130);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(confusion);

        }
    }
}
