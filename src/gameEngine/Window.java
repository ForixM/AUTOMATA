package gameEngine;

import javax.swing.*;

public class Window extends JFrame {
    public Window(int width, int height, String title){
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
