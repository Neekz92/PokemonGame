package GameEngine;

import Item.Item;
import Locations.Location;
import Moves.Move;
import POIs.POI;
import Pokemon.Pokemon;

import java.util.Random;
import java.util.Scanner;

public class Player {

    GameEngine gameEngine;
    Scanner scanner;
    Random random;

    private Location location;
    public Battle battle;

    POI selectedPOI;
    private Pokemon selectedPokemon;

    private Pokemon currentMon;
    private double rawDamage;

    private Pokemon activePokemon;
    private Move selectedMove;
    private Pokemon selectedTarget;

    private String name;

    private int x;
    private int y;

    int amountOfPokemon;
    public Pokemon[] team;

    public boolean receivedStarter;
    public boolean isInBattle;

    private boolean isNpc;

    protected Item selectedItem;
    protected Inventory inventory;

    private int money;

    // The constructor lies below
    public Player(GameEngine gameEngine) {

        this.gameEngine = gameEngine;
        scanner = new Scanner(System.in);
        random = new Random();

        x = 0;
        y = 0;

        amountOfPokemon = 0;
        team = new Pokemon[amountOfPokemon];

        inventory = new Inventory();
        inventory.player = this;

        money = 3000;
    }

    public void addItem(Item item) {

    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    protected POI setSelectedPOI() {

        boolean inputLoop = true;
        while (inputLoop) {
            try {
                int input = gameEngine.scanner.nextInt();
                gameEngine.scanner.nextLine();

                if (input == 0) {
                    selectedPOI = null;
                    inputLoop = false;
                    return null;
                }

                selectedPOI = getLocation().poiArray[input - 1];
                inputLoop = false;
            } catch (Exception e) {
                System.out.println("Invalid. " + e);
            }
        }
        return selectedPOI;
    }

    public void clearPOI() {
        selectedPOI = null;
    }

    public void addPokemon(Pokemon pokemon) {

        amountOfPokemon++;
        Pokemon[] teamClone = new Pokemon[amountOfPokemon];
        for (int i = 0; i < team.length; i++) {
            teamClone[i] = team[i];
        }
        teamClone[amountOfPokemon - 1] = pokemon;
        team = teamClone;

        pokemon.ot = name;
        pokemon.setIsNpc(false);

        System.out.println("Do you want to give a nickname to " + pokemon.getSpecies() + "?");
        System.out.println("");
        System.out.println("[ 1 ] YES");
        System.out.println("[ 2 ] NO");

        boolean wannaNickName = true;
        while (wannaNickName) {
            try {
                int input = gameEngine.scanner.nextInt();
                gameEngine.scanner.nextLine();

                switch (input) {
                    case 1:
                        boolean enterNickName = true;
                        while (enterNickName) {
                            System.out.println("Enter a nickname.");
                            String nickName = gameEngine.scanner.nextLine();
                            if (nickName.contains("*") || nickName.contains("[") || nickName.contains("]")) {
                                System.out.println("Invalid character.");
                                continue;
                            } else {
                                pokemon.setName(nickName);
                                pokemon.setHasNickName(true);
                                wannaNickName = false;
                                break;
                            }
                        }
                    case 2:
                        wannaNickName = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        }
    }

    protected void startMenu() {

        System.out.println("[ 1 ] POKeDEX");
        System.out.println("[ 2 ] POKeMON");
        System.out.println("[ 3 ] ITEM");
        System.out.println("[ 4 ] " + this);
        System.out.println("[ 5 ] SAVE");
        System.out.println("[ 6 ] OPTION");
        System.out.println("[ 7 ] EXIT");

        boolean startMenu = true;
        while (startMenu) {
            try {
                int input = gameEngine.scanner.nextInt();
                gameEngine.scanner.nextLine();

                switch (input) {
                    case 1:
                    case 2:
                        showTeam();
                        startMenu = false;
                        break;
                    case 3:
                        System.out.println("");
                        inventory.openInventory();
                        startMenu = false;
                        gameEngine.standardTurn();
                        break;

                }
            } catch (Exception e) {
                System.out.println("Invalid. from startMenu()");
                gameEngine.scanner.nextLine();
            }
        }
    }

    private void showTeam() {

        for (int i = 0; i < amountOfPokemon; i++) {
            System.out.println("[ " + (i + 1) + " ] " + team[i] + " | Level: " + team[i].getLevel() + " | HP: " + team[i].getCurrentHP() + "/ " + team[i].getHp());
        }
        System.out.println("[ 0 ] Exit");

        boolean selectPokemon = true;
        while (selectPokemon) {
            try {
                int input = gameEngine.scanner.nextInt();
                gameEngine.scanner.nextLine();

                if (input == 0) {
                    gameEngine.standardTurn();
                    return;
                }

                selectedPokemon = team[input - 1];
                selectPokemon = false;
                pokemonMenu();
                break;
            } catch (Exception e) {
                System.out.println("Invalid from showTeam()");
            }
        }
    }

    private void pokemonMenu() {

        System.out.println("Selected POKeMON: " + selectedPokemon + " | Level: " + selectedPokemon.getLevel() + " | XP: " + selectedPokemon.getXp());
        System.out.println("");
        System.out.println("[ 1 ] STATS");
        System.out.println("[ 2 ] MOVES");
        System.out.println("[ 3 ] SWITCH");
        System.out.println("[ 0 ] Exit");

        boolean pokemonOptions = true;
        while (pokemonOptions) {
            try {
                int input = gameEngine.scanner.nextInt();
                gameEngine.scanner.nextLine();

                switch (input) {
                    case 1:
                        System.out.println("Nature: " + selectedPokemon.getNature());
                        System.out.println("");
                        System.out.println("IVs:");
                        System.out.println("[ HP ]    === " + selectedPokemon.getHpIV());
                        System.out.println("[ Atk ]   === " + selectedPokemon.getAtkIV());
                        System.out.println("[ Def ]   === " + selectedPokemon.getDefIV());
                        System.out.println("[ SpAtk ] === " + selectedPokemon.getSpatkIV());
                        System.out.println("[ SpDef ] === " + selectedPokemon.getSpdefIV());
                        System.out.println("[ Speed ] === " + selectedPokemon.getSpdIV());
                        System.out.println("");

                        System.out.println("EVs:");
                        System.out.println("[ HP ]    === " + selectedPokemon.getHpEV());
                        System.out.println("[ Atk ]   === " + selectedPokemon.getAtkEV());
                        System.out.println("[ Def ]   === " + selectedPokemon.getDefEV());
                        System.out.println("[ SpAtk ] === " + selectedPokemon.getSpatkEV());
                        System.out.println("[ SpDef ] === " + selectedPokemon.getSpdefEV());
                        System.out.println("[ Speed ] === " + selectedPokemon.getSpdEV());
                        System.out.println("");

                        System.out.println("Stats:");
                        System.out.println("[ HP ]    === " + selectedPokemon.getHp());
                        System.out.println("[ Atk ]   === " + selectedPokemon.getAtk());
                        System.out.println("[ Def ]   === " + selectedPokemon.getDef());
                        System.out.println("[ SpAtk ] === " + selectedPokemon.getSpAtk());
                        System.out.println("[ SpDef ] === " + selectedPokemon.getSpDef());
                        System.out.println("[ Speed ] === " + selectedPokemon.getSpd());
                        System.out.println("");
                        pokemonOptions = false;
                        gameEngine.standardTurn();
                        break;
                    case 2:
                        selectedPokemon.showMoveSet();
                        pokemonOptions = false;
                        gameEngine.standardTurn();
                        break;

                    case 0:
                        return;
                }
            } catch (Exception e) {
                System.out.println("MAN this shit is FUCKED UP!");
            }
        }
    }

    public void battle() {

        battle = location.poi.getBattle();
        System.out.println("");

        System.out.println("");
        System.out.println("********************");
        System.out.println(getName() + "'s turn");
        System.out.println("********************");
        System.out.println("");
        System.out.println("");

        if (battle.getAmountOfNPC() == 1) {
            System.out.println(battle.incomingPokemon_wild + " | Level: " + battle.incomingPokemon_wild.getLevel() + " | HP: " + battle.incomingPokemon_wild.getCurrentHP() + "/ " + battle.incomingPokemon_wild.getHp());
            System.out.println("===============================");
        }


        System.out.println("");


        if (battle.getAmountOfPlayers() == 1) {
            System.out.println("          " + battle.incomingPokemon_fromTrainer1 + " | Level: " + battle.incomingPokemon_fromTrainer1.getLevel() + " | HP: " + battle.incomingPokemon_fromTrainer1.getCurrentHP() + "/ " + battle.incomingPokemon_fromTrainer1.getHp());
            System.out.println("=========================================");
        }

        if (battle.getAmountOfPlayers() == 2) {
            //System.out.println(battle.rawPokemonArray[0] + " | Level: " + battle.rawPokemonArray[0].getLevel() + " | HP: " + battle.rawPokemonArray[0].getCurrentHP() + "/ " + battle.rawPokemonArray[0].getHp() + "     " + battle.rawPokemonArray[2] + " | Level: " + battle.rawPokemonArray[2].getLevel() + " | HP: " + battle.rawPokemonArray[2].getCurrentHP() + "/ " + battle.rawPokemonArray[2].getHp());
            System.out.println(battle.incomingPokemon_fromTrainer1.getName() + "                       " + battle.getIncomingPokemon_fromTrainer2.getName());
            System.out.println("Level: " + battle.incomingPokemon_fromTrainer1.getLevel() + " | HP: " + battle.incomingPokemon_fromTrainer1.getCurrentHP() + "/ " + battle.incomingPokemon_fromTrainer1.getHp() + "          " + "Level: " + battle.getIncomingPokemon_fromTrainer2.getLevel() + " | HP: " + battle.getIncomingPokemon_fromTrainer2.getCurrentHP() + "/ " + battle.getIncomingPokemon_fromTrainer2.getHp());
            System.out.println("====================================================");
        }

        System.out.println("");
        System.out.println("          " + "[ 1 ] FIGHT  [ 2 ] PkMn");
        System.out.println("          " + "[ 3 ] ITEM   [ 4 ] RUN");
        battle.sortBySpeed();

        boolean battleMenu = true;
        while (battleMenu) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                        fight();
                        battleMenu = false;
                        break;
                    case 2:
                    case 3:
                        inventory.openInventory();
                        useItemInBattle();
                        battleMenu = false;
                        break;
                    case 4:
                        run();
                        battleMenu = false;
                        break;
                    default:
                }
            }

            catch (Exception e) {
                System.out.println("Invalid: " + e + " Player.battle() | currentPlayer = " + name);
            }
        }
    }


    private void fight() {

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("**************************************************");
        for (int i = 0; i < battle.rawPokemonArray.length; i++) {
            if (battle.rawPokemonArray[i].ot == null) {
                continue;
            }
        }

        for (int i = 0; i < activePokemon.getMoveSet().length; i++) {
            System.out.println("[ " + (i + 1) + " ] " + activePokemon.getMoveSet()[i]);
        }


        System.out.println("**************************************************");
        System.out.println("");
        selectMove();
        selectTarget();
    }

    private void useItemInBattle() {

        boolean useItemInBattle = true;
        while (useItemInBattle) {
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) {
                useItemInBattle = false;
                return;
            }

            selectedItem.use();
            battle.npcSelectMove();
            useItemInBattle = false;
        }
    }

    private void run() {

        battle.removeFromRawPokemonArray(getActivePokemon());
        getActivePokemon().isInBattle = false;

        battle.playerArray.remove(this);
        isInBattle = false;

        if (battle.getAmountOfPlayers() == 0) {
            getLocation().poi.setHasOngoingBattle(false);

            for (int i = battle.rawPokemonArray.length - 1; i >= 0; i--) {
                battle.removeFromRawPokemonArray(battle.rawPokemonArray[i]);
                battle.playerArray.clear();
            }
        }

        System.out.println(getActivePokemon() + " got away safely!");
    }

    private Move selectMove() {

        boolean selectMove = true;
        while (selectMove) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                selectedMove = selectedPokemon.getMoveSet()[input - 1];
                selectMove = false;
                break;
            } catch (Exception e) {
                System.out.println("Invalid, from Player.fight(), selectMove loop");
            }
        }
        activePokemon.setSelectedMove(selectedMove);
        return selectedMove;
    }


    private Pokemon selectTarget() {


        for (int i = 0; i < battle.rawPokemonArray.length; i++) {
            System.out.println("[ " + (i + 1) + " ] " + battle.rawPokemonArray[i]);
        }

        boolean selectTarget = true;
        while (selectTarget) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                selectedTarget = battle.rawPokemonArray[input - 1];
                activePokemon.setSelectedTarget(selectedTarget);
                selectTarget = false;
            } catch (Exception e) {
                System.out.println("while loop inside Player.selectTarget()");
            }
        }
        return selectedTarget;
    }

    public int getLevel() {
        return -1;
    }

    public int getCurrentHP() {
        return -1;
    }

    public int getHp() {
        return -1;
    }

    public int getSpd() {
        return -1;
    }

    public Pokemon getSelectedPokemon() {
        return selectedPokemon;
    }

    public void setSelectedPokemon(Pokemon pokemon) {
        selectedPokemon = pokemon;
    }

    public String toString() {
        return name;
    }

    public Move getSelectedMove() {
        return selectedMove;
    }

    public Pokemon getSelectedTarget() {
        return selectedTarget;
    }

    public void setSelectedTarget(Pokemon pokemon) {

        selectedTarget = pokemon;
    }

    public void setSelectedMove(Move move) {
        selectedMove = move;
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(Pokemon pokemon) {
        activePokemon = pokemon;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {

        this.money = money;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item item) {
        this.selectedItem = item;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean getIsNpc() {
        return isNpc;
    }

    public void setIsNpc(boolean npc) {
        isNpc = npc;
    }

}
