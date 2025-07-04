package Pokemon;

import GameEngine.GameEngine;

public class Caterpie extends Pokemon {

    public Caterpie(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "CATERPIE";
        setName(species);
        setType("Bug");

        weaknesses.add("Fire");
        weaknesses.add("Flying");
        weaknesses.add("Rock");

        resistances.add("Grass");
        resistances.add("Fighting");
        resistances.add("Ground");

        setBaseHp(45);
        setBaseAtk(30);
        setBaseDef(35);
        setBaseSpatk(20);
        setBaseSpdef(20);
        setBaseSpd(45);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(stringShot);
            addMoveToLearnSet(tackle);
        }
    }
}
