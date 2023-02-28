package scenes;

import gameEngine.Automata;
import gameEngine.rendering.Scene;
import world.Map;
import world.Tile;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends Scene implements MouseWheelListener, KeyListener {
//    private Map map;
    private float moove_speed = 500;
    private List<Integer> keysPressed;
    public MainWindow(){
        this.keysPressed = new ArrayList<>();
        Automata.INSTANCE.getWindow().addKeyListener(this);
        addMouseWheelListener(this);
    }

    double size = 50;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Integer integer : keysPressed) {
            switch (integer.intValue()) {
            case KeyEvent.VK_Z -> Tile.TRANSLATE_Y+=moove_speed* Automata.DELTA;
            case KeyEvent.VK_S -> Tile.TRANSLATE_Y-=moove_speed* Automata.DELTA;
            case KeyEvent.VK_Q -> Tile.TRANSLATE_X+=moove_speed* Automata.DELTA;
            case KeyEvent.VK_D -> Tile.TRANSLATE_X-=moove_speed* Automata.DELTA;
            }
        }
        Automata.INSTANCE.getMap().renderMap(g);
        g.dispose();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println(e.getWheelRotation());
        if (e.getWheelRotation() > 0){
            Tile.RENDER_SIZE*=1.05;
        } else if (e.getWheelRotation() < 0) {
            Tile.RENDER_SIZE*=0.95;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keysPressed.contains(e.getKeyCode()))
            keysPressed.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed.remove(new Integer(e.getKeyCode()));
    }
}
