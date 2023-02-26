package world;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private List<Region> regions;
    public Map(){
        this.regions = new ArrayList<>();
        for (int x = -5; x < 5; x++){
            for (int y = -5; y < 5; y++){
                regions.add(new Region(x, y));
            }
        }
    }

    public void renderMap(Graphics2D g){
        double currentX = Tile.TRANSLATE_X/(double)(Region.REGION_SIZE*Tile.RENDER_SIZE)*-1;
        double currentY = Tile.TRANSLATE_Y/(double)(Region.REGION_SIZE*Tile.RENDER_SIZE*0.75)*-1;
//        System.out.println("currentX = "+currentX+", currentY = "+currentY);
        for (int dX = -2; dX <= 2; dX++){
            for (int dY = -2; dY <= 2; dY++){
                getRegion((int) currentX+dX, (int) currentY+dY).renderRegion(g);
            }
        }
//        getRegion((int) currentX+1, (int) currentY).renderRegion(g);
//        getRegion((int) currentX+2, (int) currentY).renderRegion(g);
//        getRegion((int) currentX+1, (int) currentY+1).renderRegion(g);
//        getRegion((int) currentX+2, (int) currentY+2).renderRegion(g);
//        getRegion((int) currentX+2, (int) currentY+1).renderRegion(g);
//        getRegion((int) currentX+1, (int) currentY+2).renderRegion(g);
//        getRegion((int) currentX, (int) currentY+1).renderRegion(g);
//        getRegion((int) currentX, (int) currentY+2).renderRegion(g);
    }

    public Tile getTileAt(int x, int y){
        int regionX = x/Region.REGION_SIZE;
        int regionY = y/Region.REGION_SIZE;
        return getRegion(regionX, regionY).getTileAt(x, y);
    }

    public Region getRegion(int x, int y){
        return regions.stream().filter(r -> r.getX() == x && r.getY() == y).findFirst().get();
    }
}
