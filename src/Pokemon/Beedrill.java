package Pokemon;

import GameEngine.GameEngine;

public class Beedrill extends Pokemon {

    public Beedrill(GameEngine gameEngine, int xp) {

        super(gameEngine, xp);

        species = "BEEDRILL";
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

        setBaseHp(65);
        setBaseAtk(90);
        setBaseDef(45);
        setBaseSpatk(45);
        setBaseSpdef(80);
        setBaseSpd(75);

        updateLevel();
        setStats();
        restore();

        setNature();
        updateLearnSet();
        setupMoves();
    }

    protected void updateLearnSet() {

        if (getLevel() >= 1) {
            addMoveToLearnSet(bugBite);
            addMoveToLearnSet(furyAttack);
            addMoveToLearnSet(harden);
            addMoveToLearnSet(poisonSting);
            addMoveToLearnSet(stringShot);
        }
    }
}
