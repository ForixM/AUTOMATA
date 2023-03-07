package scenes;

import gameEngine.Automata;
import gameEngine.rendering.Scene;
import world.Region;
import world.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends Scene implements MouseListener {
    public static float MOOVE_SPEED = 500;
    private InventoryOverlay overlay;
    private boolean overlayShown = true;
    public MainWindow(){
        addMouseListener(this);
        this.overlay = new InventoryOverlay();
        CardLayout layout = new CardLayout(200, 100);
        setLayout(layout);
        add(overlay);
    }

    public void switchOverlayVisibility(){
        if (overlayShown){
            remove(overlay);
            overlayShown = false;
        } else {
            add(overlay);
            overlayShown = true;
        }
    }

    public InventoryOverlay getOverlay() {
        return overlay;
    }

    @Override
    public boolean isOptimizedDrawingEnabled() {
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Automata.INSTANCE.getMap().renderMap(g);
//        g.dispose();
//        overlay.repaint();
//        System.out.println("getBounds() = " + getBounds());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Region renderedRegion : Automata.INSTANCE.getMap().getRenderedRegions()) {
            for (Tile[] tiles : renderedRegion.getTiles()) {
                for (Tile tile : tiles) {
                    if (tile.getPolygon().contains(e.getPoint())){
                        tile.onClick();
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
