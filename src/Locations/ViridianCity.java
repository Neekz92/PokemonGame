package Locations;

import GameEngine.GameEngine;
import POIs.*;

public class ViridianCity extends Location {

    public ViridianCity(GameEngine gameEngine) {

        super(gameEngine);
        setName("Viridian City");
        addPOI(new ViridianCityPokeCenter(gameEngine));
        addPOI(new ViridianCityPokeMart(gameEngine));
        addPOI(new ViridianCityGym(gameEngine));

        x = 0;
        y = 2;

        canMoveNorth = true;
        canMoveSouth = true;
        canMoveWest = true;
    }
}
