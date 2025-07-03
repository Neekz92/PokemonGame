package Locations;

import GameEngine.GameEngine;
import POIs.ProfessorOaksLab;

public class PalletTown extends Location {

    public PalletTown(GameEngine gameEngine) {

        super(gameEngine);
        setName("Pallet Town");
        addPOI(new ProfessorOaksLab(gameEngine));

        x = 0;
        y = 0;

        canMoveNorth = true;
    }
}
