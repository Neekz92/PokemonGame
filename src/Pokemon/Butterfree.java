package Pokemon;

import GameEngine.GameEngine;

public class Butterfree extends Pokemon {

    public Butterfree(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "BUTTERFREE";
        setName(species);
        setType("Bug");
        setType2("Flying");

        weaknesses.add("Fire");
        weaknesses.add("Electric");
        weaknesses.add("Ice");
        weaknesses.add("Flying");
        weaknesses.add("Rock");

        resistances.add("Grass");
        resistances.add("Fighting");
        resistances.add("Bug");
        resistances.add("Ground");

        setBaseHp(60);
        setBaseAtk(45);
        setBaseDef(50);
        setBaseSpatk(90);
        setBaseSpdef(80);
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
            addMoveToLearnSet(bugBite);
            addMoveToLearnSet(gust);
            addMoveToLearnSet(harden);
            addMoveToLearnSet(stringShot);
            addMoveToLearnSet(tackle);
        }

        if (getLevel() >= 4) {
            addMoveToLearnSet(supersonic);
        }
    }
}
