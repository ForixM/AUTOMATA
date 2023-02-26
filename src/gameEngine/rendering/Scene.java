package gameEngine.rendering;

import javax.swing.*;
import java.awt.*;

public abstract class Scene extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
