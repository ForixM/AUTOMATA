package world;

import gameEngine.registry.capabilities.UpdatableTile;
import utils.PerlinNoise2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Map {
    private List<Region> regions;
    private List<UpdatableTile> updatableTiles;
    private List<Region> renderedRegions;
    public Map(){
        this.regions = new ArrayList<>();
        this.updatableTiles = new ArrayList<>();
        this.renderedRegions = new LinkedList<>();
        PerlinNoise2D.WIDTH = Region.REGION_SIZE;
        PerlinNoise2D.HEIGHT = Region.REGION_SIZE;
        for (int x = -5; x < 5; x++){
            for (int y = -5; y < 5; y++){
                Region region = new Region(x, y);
                regions.add(region);
            }
        }
    }

    public void renderMap(Graphics g){
        double currentX = Player.POS_X / (Region.REGION_SIZE*Tile.RENDER_SIZE) *-1;
        double currentY = Player.POS_Y / (Region.REGION_SIZE*Tile.RENDER_SIZE*0.75) *-1;
        renderedRegions.clear();
        for (int dX = -5; dX <= 5; dX++){
            for (int dY = -5; dY <= 5; dY++){
                renderedRegions.add(getRegion((int) currentX+dX, (int) currentY+dY));
//                getRegion((int) currentX+dX, (int) currentY+dY).renderRegion(g);
            }
        }
        for (Region renderedRegion : renderedRegions) {
            renderedRegion.renderRegion(g);
        }
    }

    public void updateTiles(){
        updatableTiles.forEach(UpdatableTile::update);
    }

    public void addUpdatableTile(UpdatableTile updatableTile){
        updatableTiles.add(updatableTile);
    }

    public Tile getTileAt(int x, int y){
        int regionX = x/Region.REGION_SIZE;
        int regionY = y/Region.REGION_SIZE;
        return getRegion(regionX, regionY).getTileAt(x, y);
    }

    public Region getRegion(int x, int y){
        Optional<Region> result = regions.stream().filter(r -> r.getX() == x && r.getY() == y).findFirst();
        if (result.isPresent()){
            return result.get();
        }
        Region newRegion = new Region(x, y);
        regions.add(newRegion);
        return newRegion;
    }

    public List<Region> getRenderedRegions() {
        return renderedRegions;
    }
}
