package gameEngine.registry.tiles;

import gameEngine.registry.TileBase;
import gameEngine.registry.UpdatableTile;
import gameEngine.registry.updatable.ExtractorUp;

public class Extractor extends TileBase {
    public Extractor(String registryName) {
        super(registryName);
    }

    @Override
    public UpdatableTile getUpdatableCapability() {
        return new ExtractorUp();
    }
}
