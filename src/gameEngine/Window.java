package gameEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame implements KeyListener {
    private List<Integer> keyPressed;
    public Window(int width, int height, String title){
        this.keyPressed = new ArrayList<>();
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
//            setIconImage(ImageIO.read(new File(Automata.ASSETS_PATH+"icon.png")));
            List<Image> images = new ArrayList();
//            images.add(ImageIO.read(new File(Automata.ASSETS_PATH+"icon_small.png")));
            images.add(ImageIO.read(new File(Automata.ASSETS_PATH+"icon_small.png")));
            setIconImages(images);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setVisible(true);
    }

    public List<Integer> getKeyPressed() {
        return keyPressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keyPressed.contains(e.getKeyCode())){
            keyPressed.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed.remove(e.getKeyCode());
    }
}
