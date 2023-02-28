package world;

import gameEngine.Automata;
import gameEngine.registry.Deposit;
import gameEngine.registry.TileBase;

import java.awt.*;

public class Tile {
    private TileBase base;
    private Deposit deposit;
    private TileBase placed;
    private int x, y;
    public static double RENDER_SIZE = 50;
    public static double TRANSLATE_X = 0;
    public static double TRANSLATE_Y = 0;
    public Tile(TileBase base, int x, int y){
        this.base = base;
        this.x = x;
        this.y = y;
        this.deposit = null;
    }

    public Tile(TileBase base, int x, int y, Deposit deposit){
        this(base, x, y);
        this.deposit = deposit;
    }

    public void place(TileBase placed){
        this.placed = placed;
    }

    public void render(Graphics g){
        int renderX = (int) (x *RENDER_SIZE+(y%2==0?0:RENDER_SIZE/2)+(int)TRANSLATE_X);
        int renderY = y * (int) (RENDER_SIZE * 0.75) + (int) TRANSLATE_Y;
        if (renderX >= -RENDER_SIZE && renderY > -RENDER_SIZE && renderX < Automata.WIN_WIDTH && renderY < Automata.WIN_HEIGHT) {
            g.drawImage(base.getTexture().getImage(), renderX, renderY, (int) RENDER_SIZE, (int) RENDER_SIZE, null);
            if (deposit != null) {
                g.drawImage(deposit.getTexture().getImage(), renderX, renderY, (int) RENDER_SIZE, (int) RENDER_SIZE, null);
            }
            if (placed != null){
                g.drawImage(placed.getTexture().getImage(), renderX, renderY, (int) RENDER_SIZE, (int) RENDER_SIZE, null);
            }
        }
    }

    public TileBase getBase() {
        return base;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public TileBase getPlaced() {
        return placed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
