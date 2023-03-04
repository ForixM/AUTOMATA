package gameEngine.registry.tiles;

import gameEngine.registry.base.TileBase;
import gameEngine.registry.capabilities.UpdatableTile;
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
