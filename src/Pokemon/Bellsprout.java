package Pokemon;

import GameEngine.GameEngine;

public class Bellsprout extends Pokemon {

    public Bellsprout(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

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

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(vineWhip);
        }
    }
}
