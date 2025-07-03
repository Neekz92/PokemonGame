package Pokemon;

import GameEngine.GameEngine;

public class Bellsprout extends Pokemon {

    public Bellsprout(GameEngine gameEngine, int level) {

        super(gameEngine, level);

        species = "BELLSPROUT";
        setName(species);
        setType("Grass");
        setType2("Poison");

        setBaseHp(50);
        setBaseAtk(75);
        setBaseDef(35);
        setBaseSpatk(70);
        setBaseSpdef(30);
        setBaseSpd(40);

        setStats();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(vineWhip);
        }
    }
}
