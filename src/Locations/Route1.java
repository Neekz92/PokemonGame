package Locations;

import GameEngine.GameEngine;
import POIs.Route1TallGrass;

public class Route1 extends Location {

    public Route1(GameEngine gameEngine) {

        super(gameEngine);
        setName("Route 1");
        addPOI(new Route1TallGrass(gameEngine));

        x = 0;
        y = 1;

        canMoveNorth = true;
        canMoveSouth = true;


    }
}
