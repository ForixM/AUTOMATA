import gameEngine.Engine;
import scenes.MainWindow;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello Automata!");
//        System.out.println("Hello king!");
        Engine engine = new Engine();
        MainWindow main = new MainWindow();
        engine.switchScene(main);
        engine.gameLoop();
    }
}