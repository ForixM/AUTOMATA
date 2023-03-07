import gameEngine.Automata;
import scenes.MainWindow;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello Automata!");
//        System.out.println("Hello king!");
        Automata engine = new Automata();
        MainWindow main = new MainWindow();
        engine.switchScene(main);
//        PerlinScene scene = new PerlinScene();
        engine.gameLoop();

//        BufferedImage img = PerlinNoise2D.getNoiseImage();
//        for (int x = 0; x < PerlinNoise2D.WIDTH; x++){
//            for (int y = 0; y < PerlinNoise2D.HEIGHT; y++){
//                System.out.print("("+x+","+y+")="+img.getRGB(x, y)+",");
//            }
//            System.out.println();
//        }
    }
}