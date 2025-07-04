package Pokemon;

import GameEngine.GameEngine;

public class Charmander extends Pokemon {

    public Charmander(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "CHARMANDER";
        setName(species);
        setType("Fire");

        weaknesses.add("Water");
        weaknesses.add("Ground");
        weaknesses.add("Rock");

        resistances.add("Fire");
        resistances.add("Grass");
        resistances.add("Ice");
        resistances.add("Bug");
        resistances.add("Steel");
        resistances.add("Fairy");

        setBaseHp(39);
        setBaseAtk(52);
        setBaseDef(43);
        setBaseSpatk(60);
        setBaseSpdef(50);
        setBaseSpd(65);

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
            addMoveToLearnSet(scratch);
        }

        if (getLevel() >= 4) {
            addMoveToLearnSet(ember);
        }
    }
}
