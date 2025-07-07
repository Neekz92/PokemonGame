package Moves;

import GameEngine.Player;

public class Move {

    String name;
    int pp;
    int accuracy;
    String type;
    String category;
    int power;

    private Player player;

    public Move(String name, String type, String category, int power, int accuracy, int pp) {

        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }

    public Move() {

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }


    public int getPp() {
        return pp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return getName() + " | Type: " + getType() + " | Power: " + getPower() + " | PP: " + getPp();
    }
}
