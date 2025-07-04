package Locations;

import GameEngine.GameEngine;
import POIs.ViridianForestTallGrass;

public class ViridianForest extends Location {

    public ViridianForest(GameEngine gameEngine) {

        super(gameEngine);
        setName("Viridian Forest");
        addPOI(new ViridianForestTallGrass(gameEngine));


        x = 0;
        y = 4;

        canMoveNorth = true;
        canMoveSouth = true;
    }
}
