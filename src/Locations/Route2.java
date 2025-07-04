package Locations;

import GameEngine.GameEngine;
import POIs.Route2TallGrass;

public class Route2 extends Location {

    public Route2(GameEngine gameEngine) {

        super(gameEngine);
        setName("Route 2");
        addPOI(new Route2TallGrass(gameEngine));


        x = 0;
        y = 3;

        canMoveNorth = true;
        canMoveSouth = true;
    }
}
