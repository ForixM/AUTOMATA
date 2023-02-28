package scenes;

import gameEngine.rendering.Scene;
import utils.PerlinNoise2D;

import java.awt.*;

public class PerlinScene extends Scene {
    private int x = 0;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(PerlinNoise2D.getNoiseImage(0, 0, 0, 1), 0, 0, 600, 600, this);
        g.drawImage(PerlinNoise2D.getNoiseImage(0, 100, 0, 1), 600, 0, 600, 600, this);
//        x+=110* Engine.DELTA;
//        System.out.println(x);
    }
}
