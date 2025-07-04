package Pokemon;

import GameEngine.GameEngine;

public class Pidgey extends Pokemon {

    public Pidgey(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "PIDGEY";
        setName(species);
        setType("Normal");
        setType2("Flying");

        weaknesses.add("Electric");
        weaknesses.add("Rock");
        weaknesses.add("Ice");

        resistances.add("Grass");
        resistances.add("Bug");

        setBaseHp(40);
        setBaseAtk(45);
        setBaseDef(40);
        setBaseSpatk(35);
        setBaseSpdef(35);
        setBaseSpd(56);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(tackle);
        }
    }
}
