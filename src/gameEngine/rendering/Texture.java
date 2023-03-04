package gameEngine.rendering;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Texture {
    public static int ID_COUNT = 0;
    private Image texture;
    private int id;
    public Texture(String path, int renderSize){
        try {
            BufferedImage resizedImage = new BufferedImage(renderSize, renderSize, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(ImageIO.read(new File(path)), 0, 0, renderSize, renderSize, null);
            g.dispose();
            this.texture = resizedImage;
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
