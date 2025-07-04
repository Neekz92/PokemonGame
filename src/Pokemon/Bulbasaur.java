package Pokemon;

import GameEngine.GameEngine;

public class Bulbasaur extends Pokemon {

    public Bulbasaur(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "BULBASAUR";
        setName(species);
        setType("Grass");
        setType2("Poison");

        weaknesses.add("Fire");
        weaknesses.add("Flying");
        weaknesses.add("Ice");

        resistances.add("Water");
        resistances.add("Grass");
        resistances.add("Electric");
        resistances.add("Fighting");
        resistances.add("Fairy");

        setBaseHp(45);
        setBaseAtk(49);
        setBaseDef(49);
        setBaseSpatk(65);
        setBaseSpdef(65);
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
            addMoveToLearnSet(growl);
            addMoveToLearnSet(tackle);
        }

        if (getLevel() >= 3) {
            addMoveToLearnSet(vineWhip);
        }
    }
}
