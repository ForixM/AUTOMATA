package scenes;

import gameEngine.Automata;
import gameEngine.registry.capabilities.Storage;
import gameEngine.rendering.Scene;
import world.Item;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class InventoryOverlay extends Scene implements MouseListener {
    private Image image;
    private Storage inventory;
    private Rectangle[] slots;
    public InventoryOverlay(){
        addMouseListener(this);
        try {
            this.image = ImageIO.read(new File(Automata.TEXTURE_PATH+"/overlay/inventory.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.inventory = new Storage(15) {};
        this.slots = new Rectangle[inventory.getCapacity()];

        Thread t = new Thread(this::waitInitThread);
        t.start();
    }

    private void waitInitThread(){
        while (getBounds().getWidth() <= 0 || getBounds().getHeight() <= 0){}
        int gapH = (int)((double)getWidth()*10.0/1600.0);
        int gapV = getHeight()*10/960;
        int slotSizeH = getWidth()/5-gapH;
        int slotSizeV = getHeight()/3-gapV;
        for (int i = 0; i < this.slots.length; i++) {
            this.slots[i] = new Rectangle(i%5*slotSizeH+(gapH*(i%5+1)), i/5*slotSizeV+(gapV*(i/5+1)), slotSizeH, slotSizeV);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        Storage playerInventory = Automata.INSTANCE.getPlayer().getInventory();
        for (int i = 0; i < playerInventory.getCapacity(); i++) {
            if (playerInventory.getContainer()[i] != Item.EMPTY){
                g.drawImage(playerInventory.getContainer()[i].getBase().getTexture().getImage(), (int) slots[i].getX(), (int) slots[i].getY(), (int) slots[i].getWidth(), (int) slots[i].getHeight(), null);
                g.setColor(Color.RED);
                g.drawString(Integer.toString(playerInventory.getContainer()[i].getCount()), (int) slots[i].getX() + 5, (int) slots[i].getY() + 15);
            }
        }
//        Item[] items = Automata.INSTANCE.getPlayer().getInventory().getContainer();
//        for (int i = 0; i < items.length; i++) {
//            if (items[i] != Item.EMPTY) {
//                g.drawImage(items[i].getBase().getTexture().getImage(), (int) slots[i].getX(), (int) slots[i].getY(), (int) slots[i].getWidth(), (int) slots[i].getHeight(), null);
//                g.setColor(Color.RED);
//                g.drawString(Integer.toString(items[i].getCount()), (int) slots[i].getX() + 5, (int) slots[i].getY() + 15);
//            }
//        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].contains(e.getPoint())){
                System.out.println("CLicked on slot "+i);
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
