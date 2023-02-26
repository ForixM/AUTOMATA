package world;

import gameEngine.registry.TileBase;

import java.awt.*;

public class Tile {
    private TileBase base;
    private int x, y;
    public static double RENDER_SIZE = 50;
    public static double TRANSLATE_X = 0;
    public static double TRANSLATE_Y = 0;
    public Tile(TileBase base, int x, int y){
        this.base = base;
        this.x = x;
        this.y = y;
    }

    public void render(Graphics2D g){
        g.drawImage(base.getTexture().getImage(),
                (int) ((int)x*RENDER_SIZE+(y%2==0?0:RENDER_SIZE/2)+(int)TRANSLATE_X),
                (int)y*(int)(RENDER_SIZE*0.75)+(int)TRANSLATE_Y,
                (int) RENDER_SIZE,
                (int) RENDER_SIZE,
                null);
    }
}
