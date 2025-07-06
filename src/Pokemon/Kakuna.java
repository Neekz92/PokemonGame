package Pokemon;

import GameEngine.GameEngine;

public class Kakuna extends Pokemon {

    public Kakuna(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "KAKUNA";
        setName(species);
        setType("Bug");
        setType2("Poison");

        weaknesses.add("Fire");
        weaknesses.add("Flying");
        weaknesses.add("Psychic");
        weaknesses.add("Rock");

        resistances.add("Grass");
        resistances.add("Fighting");
        resistances.add("Poison");
        resistances.add("Bug");
        resistances.add("Fairy");

        setBaseHp(45);
        setBaseAtk(25);
        setBaseDef(50);
        setBaseSpatk(25);
        setBaseSpdef(25);
        setBaseSpd(35);

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