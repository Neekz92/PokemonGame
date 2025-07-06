package POIs;

import GameEngine.*;
import Item.*;

public class ViridianCityPokeMart extends POI {

    public ViridianCityPokeMart(GameEngine gameEngine) {

        super(gameEngine);
        setName("POKeMART");

        shop = new Inventory();
        Item pokeball = new Pokeball();
        Item potion = new Potion();
        Item antidote = new Antidote();
        Item paralyzeHeal = new ParalyzeHeal();
        Item burnHeal = new BurnHeal();

        shop.addItem(pokeball);
        shop.addItem(potion);
        shop.addItem(antidote);
        shop.addItem(paralyzeHeal);
        shop.addItem(burnHeal);
    }

    @Override
    public void execute() {

        System.out.println("Hi there!");
        GameEngine.delay(750);
        System.out.println("May I help you?");
        GameEngine.delay(500);
        System.out.println("Take your time.");
        System.out.println("");
        System.out.println("*************************");
        System.out.println("[ 1 ] BUY");
        System.out.println("[ 2 ] SELL");
        System.out.println("[ 0 ] QUIT");
        System.out.println("*************************");

        boolean buySellQuit = true;
        while (buySellQuit) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch(input) {
                    case 1:
                        showShop();
                        buyItem();
                        buySellQuit = false;
                        break;
                    case 0:
                        buySellQuit = false;
                        break;

                }
            }
            catch(Exception e) {
                System.out.println(e + " from ViridianCityPokeMart.execute()");
            }
        }
    }
}
