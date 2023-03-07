package gameEngine.registry.capabilities;

import gameEngine.registry.base.TileBase;
import world.Tile;

public abstract class UpdatableTile{
    protected Tile tile;
    public UpdatableTile(Tile tile){
        this.tile = tile;
    }

    public abstract void update();
}
