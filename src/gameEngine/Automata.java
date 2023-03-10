package gameEngine;

import gameEngine.registry.Registration;
import gameEngine.registry.tiles.Chest;
import gameEngine.rendering.Scene;
import scenes.InventoryOverlay;
import scenes.MainWindow;
import world.Item;
import world.Map;
import world.Player;
import world.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Automata {
    public static final String ASSETS_PATH = "assets/";
    public static final String TEXTURE_PATH = ASSETS_PATH+"textures/";
    public static int WIN_WIDTH = 1280;
    public static int WIN_HEIGHT = 720;
    public static final int FPS = 120; //Frames Per Second
    public static final int UPS = 20; //Update Per Second
    public static double DELTA = (double)1/FPS;

    private Map map;
    private Player player;

    private Window window;
    private Scene scene;

    private Thread renderThread;
    private Thread logicThread;

    private KeyHandling keyHandling;

    public static Automata INSTANCE;
    public Automata(){
        this.keyHandling = new KeyHandling();
        window = new Window(WIN_WIDTH, WIN_HEIGHT, "default");
        INSTANCE = this;
        this.player = new Player();
        this.map = new Map();
        map.getTileAt(1, 6).place(Registration.extractor.get());
        map.addUpdatableTile(map.getTileAt(1, 6).getPlaced().getUpdatableCapability(map.getTileAt(1, 6)));
        map.getTileAt(0, 1).place(Registration.chest.get());
        Tile tile = map.getTileAt(0, 1);
        if (tile.getStorage() != null){
            System.out.println("storage: "+tile.getStorage());
            tile.getStorage().insert(new Item(Registration.stick.get(), 1));
            System.out.println("storage: "+tile.getStorage().getContainer());
        }
        this.renderThread = new Thread(this::renderLoop);
        this.logicThread = new Thread(this::logicLoop);
        registerKeys();
    }

    public KeyHandling getKeyHandling() {
        return keyHandling;
    }

    private void registerKeys(){
        keyHandling.handleKey(KeyEvent.VK_Z, () -> Player.POS_Y += MainWindow.MOOVE_SPEED * Automata.DELTA, false);
        keyHandling.handleKey(KeyEvent.VK_S, () -> Player.POS_Y -= MainWindow.MOOVE_SPEED * Automata.DELTA, false);
        keyHandling.handleKey(KeyEvent.VK_Q, () -> Player.POS_X += MainWindow.MOOVE_SPEED * Automata.DELTA, false);
        keyHandling.handleKey(KeyEvent.VK_D, () -> Player.POS_X -= MainWindow.MOOVE_SPEED * Automata.DELTA, false);
        keyHandling.handleKey(KeyEvent.VK_A, () -> {
            if (window.getContentPane() instanceof MainWindow mainWindow){
                mainWindow.switchOverlayVisibility();
                System.out.println("visibility changed");
            }
        }, true);
    }

    /**
     * Used to switch the current displaying scene in the window.
     * @param scene A Scene to be displayed to the screen
     * @param <T> Any class can be passed as a parameter while it extends the Scene abstract class
     */
    public <T extends Scene> void switchScene(T scene){
        this.scene = scene;
        window.setContentPane(scene);
        window.setVisible(true);
    }

    /**
     * Main game loop. Where game displaying and logic should be executed.
     */
    public void gameLoop(){
        logicThread.start();
        renderThread.start();
    }

    private void renderLoop(){
        int count = 0;
        long firstTime = System.currentTimeMillis();
        while (true){
            long previousTime = System.nanoTime();
            keyHandling.handleKeys();
            scene.repaint();
//                System.out.println("render time: "+((double)(System.nanoTime()-previousTime))+"ms");
            try {
                Thread.sleep((long) Math.abs((1000/FPS)));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DELTA = (double)(System.nanoTime()-previousTime)/1000000000;
            count++;
//                System.out.println("DELTA="+DELTA);
        }
//        System.out.println("finished test with "+count+" frames rendered");
    }

    private void logicLoop(){
        while (true){
            map.updateTiles();
            try {
                Thread.sleep(1000/UPS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //GETTERS AND SETTER

    public Window getWindow() {
        return window;
    }

    public Scene getScene() {
        return scene;
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }
}
