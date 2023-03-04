package scenes;

import gameEngine.Automata;
import gameEngine.rendering.Scene;

import java.awt.*;

public class MainWindow extends Scene {
    public static float MOOVE_SPEED = 500;
    public MainWindow(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Automata.INSTANCE.getMap().renderMap(g);
        g.dispose();
    }
}
