package world;

import gameEngine.registry.Registration;
import gameEngine.registry.capabilities.Storage;

public class Player {

    private Storage inventory;
    public static double POS_X = 0;
    public static double POS_Y = 0;
    public Player(){
        this.inventory = new Storage(15) {};
        inventory.insert(new Item(Registration.stick.get(), 1));
    }

    public Storage getInventory() {
        return inventory;
    }
}
