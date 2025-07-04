package Locations;

import GameEngine.GameEngine;
import POIs.POI;
import POIs.PlayerHouse;
import POIs.ProfessorOaksLab;

public class PalletTown extends Location {

    POI playersHouse;

    public PalletTown(GameEngine gameEngine) {

        super(gameEngine);
        setName("Pallet Town");
        playersHouse = new PlayerHouse(gameEngine);
        addPOI(playersHouse);
        addPOI(new ProfessorOaksLab(gameEngine));

        x = 0;
        y = 0;

        canMoveNorth = true;
    }

    public void updateHouseName() {

        playersHouse.setName(gameEngine.getPlayer().getName() + "'s House");
    }
}
