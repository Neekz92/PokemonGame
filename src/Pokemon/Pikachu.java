package Pokemon;

import GameEngine.GameEngine;

public class Pikachu extends Pokemon {

    public Pikachu(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "PIKACHU";
        setName(species);
        setType("Electric");

        weaknesses.add("Ground");

        resistances.add("Electric");
        resistances.add("Flying");
        resistances.add("Steel");

        setBaseHp(35);
        setBaseAtk(55);
        setBaseDef(40);
        setBaseSpatk(50);
        setBaseSpdef(50);
        setBaseSpd(90);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(charm);
            addMoveToLearnSet(growl);
            addMoveToLearnSet(nastyPlot);
            addMoveToLearnSet(nuzzle);
            addMoveToLearnSet(playNice);
            addMoveToLearnSet(quickAttack);
            addMoveToLearnSet(sweetKiss);
            addMoveToLearnSet(tailWhip);
            addMoveToLearnSet(thunderShock);
            addMoveToLearnSet(thunderWave);
        }
    }
}
