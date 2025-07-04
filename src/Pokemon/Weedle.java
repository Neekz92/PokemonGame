package Pokemon;

import GameEngine.GameEngine;

public class Weedle extends Pokemon {

    public Weedle(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "WEEDLE";
        setName(species);
        setType("Bug");
        setType2("Poison");

        weaknesses.add("Fire");
        weaknesses.add("Flying");
        weaknesses.add("Rock");
        weaknesses.add("Psychic");

        resistances.add("Grass");
        resistances.add("Fighting");
        resistances.add("Poison");
        resistances.add("Bug");
        resistances.add("Fairy");

        setBaseHp(40);
        setBaseAtk(35);
        setBaseDef(30);
        setBaseSpatk(20);
        setBaseSpdef(20);
        setBaseSpd(50);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(poisonSting);
            addMoveToLearnSet(stringShot);
        }
    }
}
