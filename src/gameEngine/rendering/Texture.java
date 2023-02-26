package gameEngine.rendering;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Texture {
    public static int ID_COUNT = 0;
    private Image texture;
    private int id;
    public Texture(String path){
        try {
            this.texture = ImageIO.read(new File(path));
            id = ID_COUNT++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Image getImage() {
        return texture;
    }

    public int getId() {
        return id;
    }
}
