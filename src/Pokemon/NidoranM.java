package Pokemon;

import GameEngine.GameEngine;

public class NidoranM extends Pokemon {

    public NidoranM(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "NIDORAN♂";
        setName(species);
        setType("Poison");

        weaknesses.add("Ground");
        weaknesses.add("Psychic");

        resistances.add("Grass");
        resistances.add("Fighting");
        resistances.add("Poison");
        resistances.add("Bug");
        resistances.add("Fairy");

        setBaseHp(46);
        setBaseAtk(57);
        setBaseDef(40);
        setBaseSpatk(40);
        setBaseSpdef(40);
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
            addMoveToLearnSet(leer);
            addMoveToLearnSet(poisonSting);
        }
    }
}
