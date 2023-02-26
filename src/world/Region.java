package world;

import gameEngine.registry.Registration;

import java.awt.*;
import java.util.Random;

public class Region {
    private Tile[][] tiles;
    public static final int REGION_SIZE = 16;
    private int x, y;
    public Region(int x, int y){
        Random rand = new Random();
        this.tiles = new Tile[REGION_SIZE][REGION_SIZE];
        for (int localX = 0; localX < REGION_SIZE; localX++) {
            for (int localY = 0; localY < REGION_SIZE; localY++) {
                int result = rand.nextInt(0, 3);
                if (result == 0)
                    tiles[localX][localY] = new Tile(Registration.sand.get(), localX+(x*REGION_SIZE), localY+(y*REGION_SIZE));
                else if (result == 1)
                    tiles[localX][localY] = new Tile(Registration.grass.get(), localX+(x*REGION_SIZE), localY+(y*REGION_SIZE));
                else if (result == 2)
                    tiles[localX][localY] = new Tile(Registration.water.get(), localX+(x*REGION_SIZE), localY+(y*REGION_SIZE));
            }
        }
        this.x = x;
        this.y = y;
    }

    public void renderRegion(Graphics2D g){
        for (Tile[] tileTable : tiles) {
            for (Tile tile : tileTable) {
                tile.render(g);
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTileAt(int x, int y){
        return tiles[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
