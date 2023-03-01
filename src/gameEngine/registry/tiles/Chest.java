package gameEngine.registry.tiles;

import gameEngine.registry.Storage;
import gameEngine.registry.TileBase;
import world.Item;

public class Chest extends TileBase {
    private Storage<Item> storage;
    public Chest(String registryName) {
        super(registryName);
        this.storage = new Storage<Item>(5) {};
    }

    public Storage<Item> getStorage() {
        return storage;
    }
}
