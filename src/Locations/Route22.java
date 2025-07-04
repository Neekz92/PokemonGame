package Locations;

import GameEngine.GameEngine;
import POIs.Route22TallGrass;

public class Route22 extends Location {

    public Route22(GameEngine gameEngine) {

        super(gameEngine);
        setName("Route 22");
        addPOI(new Route22TallGrass(gameEngine));

        x = -1;
        y = 2;

        canMoveEast = true;
    }
}
