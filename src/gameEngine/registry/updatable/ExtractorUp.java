package gameEngine.registry.updatable;

import gameEngine.Automata;
import gameEngine.registry.capabilities.UpdatableTile;
import world.Item;
import world.Tile;

public class ExtractorUp extends UpdatableTile {
    private int counter = 0;

    public ExtractorUp(Tile tile) {
        super(tile);
    }

    @Override
    public void update() {
        if (tile.getDeposit() != null) {
            if (counter == Automata.UPS) {
                counter = 0;
                tile.getStorage().insert(new Item(tile.getDeposit().getLoot(), 1));
                System.out.println("tile.getStorage().getContainer() = " + tile.getStorage().getContainer());
            } else {
                counter++;
            }
        } else{
            System.out.println("no deposit");
        }
    }
}
