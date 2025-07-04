package GameEngine;

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
    public boolean addedToBattleArray;

    protected boolean isNpc;

    // The constructor lies below
    public Player(GameEngine gameEngine) {

        this.gameEngine = gameEngine;
        scanner = new Scanner(System.in);
        random = new Random();

        x = 0;
        y = 0;

        amountOfPokemon = 0;
        team = new Pokemon[amountOfPokemon];
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

    protected void battle() {

        System.out.println("");

        battle = location.poi.getBattle();

        System.out.println(battle.rawPokemonArray[1] + " | Level: " + battle.rawPokemonArray[1].getLevel() + " | HP: " + battle.rawPokemonArray[1].getCurrentHP() + "/ " + battle.rawPokemonArray[1].getHp());
        System.out.println("===============================");
        System.out.println("");
        System.out.println("          " + battle.rawPokemonArray[0] + " | Level: " + battle.rawPokemonArray[0].getLevel() + " | HP: " + battle.rawPokemonArray[0].getCurrentHP() + "/ " + battle.rawPokemonArray[0].getHp());
        System.out.println("=========================================");
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
                    case 4:
                    default:
                }
            } catch (Exception e) {
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
        for (int i = 0; i < battle.battleArray.length; i++) {
            if (battle.battleArray[i].ot == null) {
                continue;
            } else if (battle.battleArray[i].ot.equals(name)) {
                for (int j = 0; j < battle.battleArray[i].getMoveSet().length; j++) {
                    System.out.println("[ " + (j + 1) + " ] " + battle.battleArray[i].getMoveSet()[j]);
                }
            }
        }
        System.out.println("**************************************************");
        System.out.println("");
        selectMove();
        selectTarget();
        npcSelectMove();
        resolveTurn();
        gameEngine.turnOrder();
    }

    private Move selectMove() {

        boolean selectMove = true;
        while (selectMove) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                selectedMove = selectedPokemon.getMoveSet()[input - 1];
//                System.out.println("DEBUG: Selected move: " + selectedMove);
                selectMove = false;
                break;
            }

            catch (Exception e) {
                System.out.println("Invalid, from Player.fight(), selectMove loop");
            }
        }
        activePokemon.setSelectedMove(selectedMove);
        return selectedMove;
    }

    private Move npcSelectMove() {

        Pokemon npc = null;

        for (int i = 0; i < battle.battleArray.length; i++) {
            if (battle.battleArray[i].isNpc && battle.battleArray[i].getCurrentHP() > 0) {
                if (battle.battleArray[i].hashCode() != selectedPokemon.hashCode()) {
                    npc = battle.battleArray[i];
                    int rng = random.nextInt(0, battle.battleArray[i].getMoveSet().length);

                    battle.battleArray[i].setSelectedMove(battle.battleArray[i].getMoveSet()[rng]);
                }
            }
        }
        return npc.getSelectedMove();
    }

    private void faint(Pokemon pokemon) {

        if (pokemon.getCurrentHP() == 0) {
            System.out.println(pokemon.getName() + " fainted!");
            pokemon.battle.removeFromBattleArray(pokemon);
            pokemon.battle.removeFromRawPokemonArray(pokemon);
            battle.distributeReward();
        }
    }

    private void useMoves() {  //  Damage formula lives here

        for (int i = 0; i < battle.battleArray.length; i++) {
            currentMon = battle.battleArray[i];
//            System.out.println("DEBUG FROM Player.useMoves() = " + battle.battleArray[i].getName());
            if (currentMon.isNpc) {
                npcSelectTarget();
            }

            System.out.println("");
            System.out.println("**************************************************");
            System.out.println(currentMon + " used " + currentMon.getSelectedMove().getName() + "!");

            double randomFactor = 0.85 + (Math.random() * 0.15);
            int damagePart1;

            if (currentMon.getCurrentHP() > 0) {
                if (currentMon.getSelectedMove().getPower() > 0) {
                    rawDamage = ((((2.0 * currentMon.getLevel()) / 5) + 2) * currentMon.getSelectedMove().getPower() * ((double) currentMon.getAtk() / currentMon.getSelectedTarget().getDef()) / 50) + 2;

                    if (currentMon.getType().equals(currentMon.getSelectedMove().getType()) ||
                       (currentMon.getType2() != null && currentMon.getType2().equals(currentMon.getSelectedMove().getType()))) {

                        rawDamage *= 1.5; // STAB!
                    }

                    if (currentMon.getSelectedTarget().weaknesses.contains(currentMon.getSelectedMove().getType())) {
                        System.out.println("It's super effective!");
                        rawDamage *= 2;
                    }

                    if (currentMon.getSelectedTarget().resistances.contains(currentMon.getSelectedMove().getType())) {
                        System.out.println("It's not very effective...");
                        rawDamage *= .5;
                    }


                    rawDamage *= randomFactor;
                    damagePart1 = (int) Math.round(rawDamage);
                } else {
                    damagePart1 = 0;
                }

//                System.out.println("DEBUG Player.useMoves(): damage = " + damagePart1);
                currentMon.getSelectedTarget().setCurrentHp(currentMon.getSelectedTarget().getCurrentHP() - damagePart1);

                System.out.println("**************************************************");
                System.out.println("");

                GameEngine.delay(750);

                faint(currentMon.getSelectedTarget());
            }
        }
    }

    private void resolveTurn() {

        useMoves();
    }

    private Pokemon selectTarget() {

        for (int i = 0; i < battle.battleArray.length; i++) {
                System.out.println("[ " + (i + 1) + " ] " + battle.battleArray[i]);
        }

        boolean selectTarget = true;
        while (selectTarget) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                selectedTarget = battle.battleArray[input - 1];
                activePokemon.setSelectedTarget(selectedTarget);
                selectTarget = false;
            } catch (Exception e) {
                System.out.println("while loop inside Player.selectTarget()");
            }
        }
//        System.out.println("Selected target: " + selectedTarget);
        return selectedTarget;
    }

    private void npcSelectTarget() {

        Pokemon npc = null;

        for (int i = 0; i < battle.battleArray.length; i++) {
            if (battle.battleArray[i].isNpc) {
                if (battle.battleArray[i].hashCode() != selectedPokemon.hashCode()) {
                    npc = battle.battleArray[i];

                    boolean npcSelectTarget = true;
                    while (npcSelectTarget) {
                        int rng = random.nextInt(0, battle.battleArray.length);
                        npc.setSelectedTarget(battle.battleArray[rng]);
                        if (npc.getSelectedTarget().hashCode() != battle.battleArray[i].hashCode()) {
                            npcSelectTarget = false;
                        }
                    }
                }
            }
        }
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
}
