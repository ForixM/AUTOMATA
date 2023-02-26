package gameEngine;

import gameEngine.rendering.Scene;

public class Engine {
    public static int WIN_WIDTH = 1280;
    public static int WIN_HEIGHT = 720;
    public static final int FPS = 120;
    public static double DELTA = (double)1/FPS;

    private Window window;
    private Scene scene;

    public static Engine INSTANCE;
    public Engine(){
        window = new Window(WIN_WIDTH, WIN_HEIGHT, "default");
        INSTANCE = this;
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
        Thread t = new Thread(() -> {
            while (true){
                long previousTime = System.nanoTime();
                scene.repaint();
//                System.out.println("render time: "+((double)(System.nanoTime()-previousTime))+"ms");
                try {
                    Thread.sleep(1000/FPS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
    }

    //GETTERS AND SETTER

    public Window getWindow() {
        return window;
    }

    public Scene getScene() {
        return scene;
    }
}
