package POIs;

import GameEngine.GameEngine;

public class ViridianCityGym extends POI {

    public ViridianCityGym(GameEngine gameEngine) {

        super(gameEngine);
        setName("GYM");
    }

    @Override
    public void execute() {

        System.out.println("The GYM's doors are locked...");
    }
}
