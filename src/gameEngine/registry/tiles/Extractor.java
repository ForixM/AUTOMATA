package gameEngine.registry.tiles;

import gameEngine.registry.base.TileBase;
import gameEngine.registry.capabilities.Storage;
import gameEngine.registry.capabilities.UpdatableTile;
import gameEngine.registry.updatable.ExtractorUp;
import world.Tile;

public class Extractor extends TileBase {
    public Extractor(String registryName) {
        super(registryName);
    }

    @Override
    public UpdatableTile getUpdatableCapability(Tile tile) {
        return new ExtractorUp(tile);
    }

    @Override
    public Storage getStorageCapability() {
        return new Storage(5) {};
    }
}
