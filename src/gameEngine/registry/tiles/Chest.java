package gameEngine.registry.tiles;

import gameEngine.registry.capabilities.Storage;
import gameEngine.registry.base.TileBase;
import world.Item;

public class Chest extends TileBase {
    public Chest(String registryName) {
        super(registryName);
    }

    @Override
    public Storage getStorageCapability() {
        return new Storage(5) {};
    }
}
