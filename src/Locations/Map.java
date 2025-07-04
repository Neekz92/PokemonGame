package Locations;

import GameEngine.*;


public class Map {

    GameEngine gameEngine;

    int amountOfLocations;
    Location[] locationArray;
    Location palletTown;
    Location route1;
    Location viridianCity;
    Location route22;

    public Map(GameEngine gameEngine) {

        this.gameEngine = gameEngine;

        amountOfLocations = 0;
        locationArray = new Location[amountOfLocations];
        palletTown = new PalletTown(gameEngine);
        route1 = new Route1(gameEngine);
        viridianCity = new ViridianCity(gameEngine);
        route22 = new Route22(gameEngine);

        addLocation(palletTown);
        addLocation(route1);
        addLocation(viridianCity);
        addLocation(route22);
    }

    public Location getPalletTown() {
        return palletTown;
    }

    private void addLocation(Location location) {

        amountOfLocations ++;
        Location[] locationArrayClone = new Location[amountOfLocations];
        for (int i = 0; i < locationArray.length; i++) {
            locationArrayClone[i] = locationArray[i];
        }
        locationArrayClone[amountOfLocations - 1] = location;
        locationArray = locationArrayClone;
    }

    public Location findLocation(Player player) {

        for (int i = 0; i < locationArray.length; i++) {
            if (player.getX() == locationArray[i].x && player.getY() == locationArray[i].y) {
                return locationArray[i];
            }
        }
        return null;
    }
}
