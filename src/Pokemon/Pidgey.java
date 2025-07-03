package Pokemon;

import GameEngine.GameEngine;

public class Pidgey extends Pokemon {

    public Pidgey(GameEngine gameEngine, int level) {

        super(gameEngine, level);

        species = "PIDGEY";
        setName(species);
        setType("Normal");
        setType2("Flying");

        setBaseHp(40);
        setBaseAtk(45);
        setBaseDef(40);
        setBaseSpatk(35);
        setBaseSpdef(35);
        setBaseSpd(56);

        setStats();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(tackle);
        }
    }
}
