package world;

import gameEngine.Automata;
import gameEngine.registry.base.Deposit;
import gameEngine.registry.base.TileBase;
import gameEngine.registry.capabilities.Storage;

import java.awt.*;

public class Tile {
    private final TileBase base;
    private Deposit deposit;
    private TileBase placed;
    private Storage storage;
    private Polygon points;
    private final int x;
    private final int y;
    public static int RENDER_SIZE = 50;
    public Tile(TileBase base, int x, int y){
        this.base = base;
        this.x = x;
        this.y = y;
        this.deposit = null;
        this.storage = null;
        this.points = new Polygon();
        rebuildPolygon();
    }

    private void rebuildPolygon(){
        points.reset();
        int renderX = x * RENDER_SIZE + (y%2==0?0:RENDER_SIZE/2) + (int)Player.POS_X;
        int renderY = y * (int) (RENDER_SIZE * 0.75) + (int) Player.POS_Y;
        points.addPoint(renderX + RENDER_SIZE/2, renderY);
        points.addPoint(renderX + RENDER_SIZE, renderY + (int) (RENDER_SIZE*0.25));
        points.addPoint(renderX + RENDER_SIZE, renderY + (int) (RENDER_SIZE*0.75));
        points.addPoint(renderX + RENDER_SIZE/2, renderY + RENDER_SIZE);
        points.addPoint(renderX, renderY + (int) (RENDER_SIZE*0.75));
        points.addPoint(renderX, renderY + (int) (RENDER_SIZE*0.25));
    }

    public Tile(TileBase base, int x, int y, Deposit deposit){
        this(base, x, y);
        this.deposit = deposit;
    }

    public void place(TileBase placed){
        this.placed = placed;
        this.storage = placed.getStorageCapability();
    }

    public void render(Graphics g){
        int renderX = x * RENDER_SIZE + (y%2==0?0:RENDER_SIZE/2) + (int)Player.POS_X;
        int renderY = y * (int) (RENDER_SIZE * 0.75) + (int) Player.POS_Y;
        rebuildPolygon();

        if (renderX >= -RENDER_SIZE && renderY > -RENDER_SIZE && renderX < Automata.WIN_WIDTH && renderY < Automata.WIN_HEIGHT) {
            g.drawImage(base.getTexture().getImage(), renderX, renderY, RENDER_SIZE, RENDER_SIZE, null);
            if (deposit != null) {
                g.drawImage(deposit.getTexture().getImage(), renderX, renderY, RENDER_SIZE, RENDER_SIZE, null);
            }
            if (placed != null){
                g.drawImage(placed.getTexture().getImage(), renderX, renderY, RENDER_SIZE, RENDER_SIZE, null);
            }
        }
    }

    public void onClick(){
        System.out.println("Tile info:");
        System.out.println("    base: "+base.getRegistryName());
        if (deposit != null)
            System.out.println("    deposit: "+deposit.getRegistryName());
        if (placed != null)
            System.out.println("    placed: "+placed.getRegistryName());
        if (storage != null) {
            System.out.println("    storage: " + storage.toString());
            Automata.INSTANCE.getPlayer().getInventory().insert((Item) storage.extract(0));
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

    public Storage getStorage() {
        return storage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Polygon getPolygon() {
        return points;
    }
}
