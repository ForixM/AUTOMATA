package world;

import gameEngine.registry.Registration;
import utils.PerlinNoise2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Region {
    private Tile[][] tiles;
    public static final int REGION_SIZE = 16;
    private int x, y;
    public Region(int x, int y){
        this.tiles = new Tile[REGION_SIZE][REGION_SIZE];
        BufferedImage noise = PerlinNoise2D.getNoiseImage(0, REGION_SIZE*x, REGION_SIZE*y, 1);
        BufferedImage noiseDeposit = PerlinNoise2D.getNoiseImage(1, REGION_SIZE*x, REGION_SIZE*y, 4);
        for (int localX = 0; localX < REGION_SIZE; localX++) {
            for (int localY = 0; localY < REGION_SIZE; localY++) {
                int result = noise.getRGB(localX, localY);
                int depositResult = noiseDeposit.getRGB(localX, localY);
                int r = (result & 0xFF0000) >> 16;
                int rD = (depositResult & 0xFF0000) >> 16;
                if (r <= 100)
                    tiles[localX][localY] = new Tile(Registration.water.get(), localX+(x*REGION_SIZE), localY+(y*REGION_SIZE));
                else if (r <= 120)
                    tiles[localX][localY] = new Tile(Registration.sand.get(), localX+(x*REGION_SIZE), localY+(y*REGION_SIZE));
                else {
                    if (rD > 200) {
                        tiles[localX][localY] = new Tile(Registration.grass.get(), localX + (x * REGION_SIZE), localY + (y * REGION_SIZE), Registration.coal.get());
                    } else {
                        tiles[localX][localY] = new Tile(Registration.grass.get(), localX + (x * REGION_SIZE), localY + (y * REGION_SIZE));
                    }
                }
            }
        }
        this.x = x;
        this.y = y;
    }
    public void renderRegion(Graphics g){
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
