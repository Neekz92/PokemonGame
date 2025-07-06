package Pokemon;

import GameEngine.GameEngine;
import GameEngine.Player;
import Moves.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Pokemon extends Player {

    Random random;

    public String ot;
    public boolean isNpc;

    private String name;
    protected String species;

    private String type;
    private String type2;

    private String nature;
    private double natureAttackMod;
    private double natureDefenseMod;
    private double natureSpAtkMod;
    private double natureSpDefMod;
    private double natureSpdMod;


    private int xp;
    private int level;

    private int baseHp;
    private int baseAtk;
    private int baseDef;
    private int baseSpatk;
    private int baseSpdef;
    private int baseSpd;

    private int hpIV;
    private int atkIV;
    private int defIV;
    private int spatkIV;
    private int spdefIV;
    private int spdIV;

    private int hpEV;
    private int atkEV;
    private int defEV;
    private int spatkEV;
    private int spdefEV;
    private int spdEV;

    private int hp;
    private int currentHP;
    private int atk;
    private int currentAtk;
    private int def;
    private int currentDef;
    private int spAtk;
    private int currentSpAtk;
    private int spDef;
    private int currentSpDef;
    private int spd;
    private int currentSpd;


    public Set<String> weaknesses;
    public Set<String> resistances;


    private int learnSetSize;
    private Move[] learnSet;
    private int moveSetSize;
    private Move[] moveSet;

    protected boolean isShiny;
    protected boolean hasNickName;

    // Adding a list of moves that each pokemon can learn
    public static Move growl = new Growl();
    public static Move tackle = new Tackle();
    public static Move vineWhip = new VineWhip();

    public static Move scratch = new Scratch();
    public static Move ember = new Ember();

    public static Move tailWhip = new TailWhip();
    public static Move waterGun = new WaterGun();

    public static Move quickAttack = new QuickAttack();

    public static Move absorb = new Absorb();
    public static Move growth = new Growth();
    public static Move acid = new Acid();

    public static Move peck = new Peck();
    public static Move leer = new Leer();

    public static Move poisonSting = new PoisonSting();

    public static Move stringShot = new StringShot();
    public static Move harden = new Harden();

    public static Move charm = new Charm();
    public static Move nastyPlot = new NastyPlot();
    public static Move nuzzle = new Nuzzle();
    public static Move playNice = new PlayNice();
    public static Move sweetKiss = new SweetKiss();
    public static Move thunderShock = new ThunderShock();
    public static Move thunderWave = new ThunderWave();

    public static Move bugBite = new BugBite();
    public static Move gust = new Gust();
    public static Move supersonic = new Supersonic();

    public static Move furyAttack = new FuryAttack();

    // the constructor lies below
    public Pokemon(GameEngine gameEngine, int xp) {

        super(gameEngine);

        this.xp = xp;
        isNpc = true;

        random = new Random();

        setHpIV(random.nextInt(0,32));
        setAtkIV(random.nextInt(0,32));
        setDefIV(random.nextInt(0,32));
        setSpatkIV(random.nextInt(0,32));
        setSpdefIV(random.nextInt(0,32));
        setSpdIv(random.nextInt(0,32));

        int natureRoll = random.nextInt(1,26);
        switch (natureRoll) {
            case 1: nature = "Hardy"; break;
            case 2: nature = "Lonely"; break;
            case 3: nature = "Adamant"; break;
            case 4: nature = "Naughty"; break;
            case 5: nature = "Brave"; break;
            case 6: nature = "Bold"; break;
            case 7: nature = "Docile"; break;
            case 8: nature = "Impish"; break;
            case 9: nature = "Lax"; break;
            case 10: nature = "Relaxed"; break;
            case 11: nature = "Modest"; break;
            case 12: nature = "Mild"; break;
            case 13: nature = "Bashful"; break;
            case 14: nature = "Rash"; break;
            case 15: nature = "Quiet"; break;
            case 16: nature = "Calm"; break;
            case 17: nature = "Gentle"; break;
            case 18: nature = "Careful"; break;
            case 19: nature = "Quirky"; break;
            case 20: nature = "Sassy"; break;
            case 21: nature = "Timid"; break;
            case 22: nature = "Hasty"; break;
            case 23: nature = "Jolly"; break;
            case 24: nature = "Naive"; break;
            case 25: nature = "Serious"; break;
        }

        weaknesses = new HashSet<>();
        resistances = new HashSet<>();

        learnSetSize = 0;
        learnSet = new Move[learnSetSize];

        moveSetSize = 0;
        moveSet = new Move[moveSetSize];

        int shinyRoll = random.nextInt(1,101);
        if (shinyRoll == 1) {
            isShiny = true;
        }
    }

    public void updateLevel() {

        if (xp < 9) {
            level = 1;
        }
        else if (xp < 57) {
            if (ot != null && level == 1) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 2;

        } else if (xp < 96) {
            if (ot != null && level == 2) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 3;

        }
        else if (xp < 135) {
            if (ot != null && level == 3) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 4;

        }
        else if (xp < 179) {
            if (ot != null && level == 4) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 5;

        }
        else if (xp < 236) {
            if (ot != null && level == 5) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 6;

        }
        else if (xp < 314) {
            if (ot != null && level == 6) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 7;

        }
        else if (xp < 419) {
            if (ot != null && level == 7) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 8;

        }
        else if (xp < 560) {
            if (ot != null && level == 8) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 9;

        }
        else if (xp < 742) {
            if (ot != null && level == 9) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 10;

        }
        else if (xp < 973) {
            if (ot != null && level == 10) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 11;

        }
        else if (xp < 1261) {
            if (ot != null && level == 11) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 12;

        }
        else if (xp < 1612) {
            if (ot != null && level == 12) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 13;

        }
        else if (xp < 2025) {
            if (ot != null && level == 13) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 14;

        }
        else if (xp < 2506) {
            if (ot != null && level == 14) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 15;

        }
        else if (xp < 3064) {
            if (ot != null && level == 15) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 16;

        }
        else if (xp < 3703) {
            if (ot != null && level == 16) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 17;

        }
        else if (xp < 4429) {
            if (ot != null && level == 17) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 18;

        }
        else if (xp < 5248) {
            if (ot != null && level == 18) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 19;

        }
        else {
            if (ot != null && level == 19) {
                System.out.println(name + " grew to level " + (level + 1) + "!");
                restore();
            }
            level = 20;

        }
    }

    public void setStats() {
        setHp();
        setAtk();
        setDef();
        setSpAtk();
        setSpDef();
        setSpd();
    }

    public void setNature() {

        switch (nature) {
            case "Hardy":
                break;
            case "Lonely":
                atk *= 1.1;
                def /= 1.1;
                break;
            case "Adamant":
                atk *= 1.1;
                spAtk /= 1.1;
                break;
            case "Naughty":
                atk *= 1.1;
                spDef /= 1.1;
                break;
            case "Brave":
                atk *= 1.1;
                spd /= 1.1;
                break;

            case "Bold":
                def *= 1.1;
                atk /= 1.1;
                break;
            case "Docile":
                break;
            case "Impish":
                def *= 1.1;
                spAtk /= 1.1;
                break;
            case "Lax":
                def *= 1.1;
                spDef /= 1.1;
                break;
            case "Relaxed":
                def *= 1.1;
                spd /= 1.1;
                break;

            case "Modest":
                spAtk *= 1.1;
                atk /= 1.1;
                break;
            case "Mild":
                spAtk *= 1.1;
                def /= 1.1;
                break;
            case "Bashful":
                break;
            case "Rash":
                spAtk *= 1.1;
                spDef /= 1.1;
                break;
            case "Quiet":
                spAtk *= 1.1;
                spd /= 1.1;
                break;

            case "Calm":
                spDef *= 1.1;
                atk /= 1.1;
                break;
            case "Gentle":
                spDef *= 1.1;
                def /= 1.1;
                break;
            case "Careful":
                spDef *= 1.1;
                spAtk /= 1.1;
                break;
            case "Quirky":
                break;
            case "Sassy":
                spDef *= 1.1;
                spd /= 1.1;
                break;

            case "Timid":
                spd *= 1.1;
                atk /= 1.1;
                break;
            case "Hasty":
                spd *= 1.1;
                def /= 1.1;
                break;
            case "Jolly":
                spd *= 1.1;
                spAtk /= 1.1;
                break;
            case "Naive":
                spd *= 1.1;
                spDef /= 1.1;
                break;
            case "Serious":
                break;
        }
    }

    protected void setupMoves() {

        while (moveSet.length < 4 && moveSet.length < learnSet.length) {

            if (moveSet.length == 4) {
                break;
            }

            Move currentMove = learnSet[random.nextInt(0,learnSet.length)];

            if (!contains(currentMove)) {
                addMove(currentMove);
            }
        }
    }

    public void setName(String name) {

        this.name = name;
    }

    public boolean getHasNickName() {
        return hasNickName;
    }

    public void setHasNickName(boolean trueOrFalse) {
        hasNickName = trueOrFalse;
    }

    public void setBaseHp(int baseHP) {
        this.baseHp = baseHP;
    }

    public void setBaseAtk(int baseAtk) {
        this.baseAtk = baseAtk;
    }

    public void setBaseDef(int baseDef) {
        this.baseDef = baseDef;
    }

    public void setBaseSpatk(int baseSpatk) {
        this.baseSpatk = baseSpatk;
    }

    public void setBaseSpdef(int baseSpdef) {
        this.baseSpdef = baseSpdef;
    }

    public void setBaseSpd(int baseSpd) {
        this.baseSpd = baseSpd;
    }

    public void setCurrentHp(int hp) {
        this.currentHP = hp;

        if (currentHP < 0) {
            currentHP = 0;
        }
    }
    public void setHp() {
        this.hp = (int)Math.floor((((2 * baseHp + hpIV + Math.floor(hpEV/4.0)) * level) / 100.0) + level + 10);
    } // contains stat formula

    public void setAtk() {
        this.atk = (int)Math.floor((Math.floor(2 * baseAtk + atkIV + Math.floor(atkEV/4.0)) * level) / 100.0) + 5;
    }

    public void setDef() {
        this.def = (int)Math.floor((Math.floor(2 * baseDef + defIV + Math.floor(defEV/4.0)) * level) / 100.0) + 5;
    }

    public void setSpAtk() {
        this.spAtk = (int)Math.floor((Math.floor(2 * baseSpatk + spatkIV + Math.floor(spatkEV/4.0)) * level) / 100.0) + 5;
    }

    public void setSpDef() {
        this.spDef = (int)Math.floor((Math.floor(2 * baseSpdef + spdefIV + Math.floor(spdefEV/4.0)) * level) / 100.0) + 5;
    }

    public void setSpd() {
        this.spd = (int)Math.floor((Math.floor(2 * baseSpd + spdIV + Math.floor(spdEV/4.0)) * level) / 100.0) + 5;
    }

    public int getHpIV() {
        return hpIV;
    }
    public void setHpIV(int hpIV) {

        this.hpIV = hpIV;
    }

    public int getAtkIV() {
        return atkIV;
    }
    public void setAtkIV(int atkIV) {

        this.atkIV = atkIV;
    }

    public int getDefIV() {
        return defIV;
    }
    public void setDefIV(int defIV) {

        this.defIV = defIV;
    }

    public int getSpatkIV() {
        return spatkIV;
    }
    public void setSpatkIV(int spatkIV) {

        this.spatkIV = spatkIV;
    }

    public int getSpdefIV() {
        return spdefIV;
    }
    public void setSpdefIV(int spdefIV) {

        this.spdefIV = spdefIV;
    }

    public int getSpdIV() {
        return spdIV;
    }
    public void setSpdIv(int spdIV) {

        this.spdIV = spdIV;
    }

    public int getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(int hp) {
        this.currentHP = hp;
    }

    public int getHp() {
        return hp;
    }
    public int getAtk() {
        return atk;
    }
    public int getDef() {
        return def;
    }
    public int getSpAtk() {
        return spAtk;
    }
    public int getSpDef() {
        return spDef;
    }
    public int getSpd() {
        return spd;
    }

    public int getHpEV() {
        return hpEV;
    }

    public int getAtkEV() {
        return atkEV;
    }

    public int getDefEV() {
        return defEV;
    }

    public int getSpatkEV() {
        return spatkEV;
    }

    public int getSpdefEV() {
        return spdefEV;
    }

    public int getSpdEV() {
        return spdEV;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int Level) {
        this.level = level;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String toString() {

        if (!hasNickName) {
            if (isShiny) {
                return "*** [Shiny] " + species + " ***";
            }
            return species;
        }

        else {
            if (isShiny) {
                return "*** [Shiny] " + name + " *** [ " + species + " ]";
            }
            return name + " [ " + species + " ]";
        }
    }

    public String getType() {
        return type;
    }
    public String getType2() {
        return type2;
    }

    public void setType(String type) {

        this.type = type;
    }
    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void restore() {

        setCurrentHp(hp);
    }

    protected void updateLearnSet() {

    }

    public void addMoveToLearnSet(Move move) {

        learnSetSize++;
        Move[] learnSetClone = new Move[learnSetSize];
        for (int i = 0; i < learnSet.length; i++) {
            learnSetClone[i] = learnSet[i];
        }
        learnSetClone[learnSetSize - 1] = move;
        learnSet = learnSetClone;
    }

    public void addMove(Move move) {

        Move moveClone = new Move(move.getName(), move.getType(), move.getCategory(), move.getPower(), move.getAccuracy(), move.getPp());

        moveSetSize ++;
        Move[] moveSetClone = new Move[moveSetSize];
        for (int i = 0 ; i < moveSet.length; i++) {
            moveSetClone[i] = moveSet[i];
        }
        moveSetClone[moveSetSize - 1] = moveClone;
        moveSet = moveSetClone;
    }

    public boolean contains(Move move) {

        for (int i = 0; i < moveSet.length; i++) {
            if (moveSet[i].getName().equals(move.getName())) {
                return true;
            }
        }
        return false;
    }

    public void showMoveSet() {

        for (int i = 0; i < moveSet.length; i++) {
            System.out.println(moveSet[i].getName() + " | Type: " + moveSet[i].getType() + " | Power: " + moveSet[i].getPower() + " | PP: " + moveSet[i].getPp());
        }
        System.out.println("");
    }

    public Move[] getLearnSet() {
        return learnSet;
    }

    public Move[] getMoveSet() {
        return moveSet;
    }

    public void setIsNpc(boolean isNpc) {
        this.isNpc = isNpc;
    }
}
