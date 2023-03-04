package gameEngine;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KeyHandling {
    private List<Integer> pressedKeys;
    private Map<Integer, Runnable> handledKeys;
    public KeyHandling(){
        this.pressedKeys = new LinkedList<>();
        this.handledKeys = new HashMap<>();
        Runnable test = () -> System.out.println("coucou");
        handleKey(KeyEvent.VK_A, test);
    }

    public void keyPressed(int keyCode){
        if (!pressedKeys.contains(keyCode)){
            pressedKeys.add(keyCode);
        }
    }

    public void keyReleased(int keyCode){
        pressedKeys.remove(new Integer(keyCode));
    }

    public void handleKey(int keyCode, Runnable func){
        handledKeys.put(keyCode, func);
    }

    public void handleKeys(){
        for (Integer pressedKey : pressedKeys) {
            handledKeys.forEach((keyCode, action) -> {
                if (pressedKey.intValue() == keyCode){
                    action.run();
                }
            });
        }
    }
}
