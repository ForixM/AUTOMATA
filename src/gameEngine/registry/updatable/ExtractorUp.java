package gameEngine.registry.updatable;

import gameEngine.registry.UpdatableTile;

public class ExtractorUp extends UpdatableTile {
    private int test = 0;
    private int x, y;
    public ExtractorUp() {
    }

    @Override
    public void update() {
        test++;
//        System.out.println("update, test: "+test);
    }
}
