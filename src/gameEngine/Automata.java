package gameEngine;

import gameEngine.registry.Registration;
import gameEngine.rendering.Scene;
import world.Map;

public class Automata {
    public static final String ASSETS_PATH = "assets/";
    public static final String TEXTURE_PATH = ASSETS_PATH+"textures/";
    public static int WIN_WIDTH = 1280;
    public static int WIN_HEIGHT = 720;
    public static final int FPS = 60; //Frames Per Second
    public static final int UPS = 20; //Update Per Second
    public static double DELTA = (double)1/FPS;

    private Map map;

    private Window window;
    private Scene scene;

    private Thread renderThread;
    private Thread logicThread;

    public static Automata INSTANCE;
    public Automata(){
        window = new Window(WIN_WIDTH, WIN_HEIGHT, "default");
        INSTANCE = this;
        this.map = new Map();
        map.getTileAt(0, 0).place(Registration.extractor.get());
        map.addUpdatableTile(map.getTileAt(0, 0).getPlaced().getUpdatableCapability());
        this.renderThread = new Thread(this::renderLoop);
        this.logicThread = new Thread(this::logicLoop);
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
}
