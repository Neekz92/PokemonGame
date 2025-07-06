package Pokemon;

import GameEngine.GameEngine;

public class Metapod extends Pokemon {

    public Metapod(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "METAPOD";
        setName(species);
        setType("Bug");

        weaknesses.add("Fire");
        weaknesses.add("Flying");
        weaknesses.add("Rock");

        resistances.add("Grass");
        resistances.add("Fighting");
        resistances.add("Ground");

        setBaseHp(50);
        setBaseAtk(20);
        setBaseDef(55);
        setBaseSpatk(25);
        setBaseSpdef(25);
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
            addMoveToLearnSet(harden);
        }
    }
}
