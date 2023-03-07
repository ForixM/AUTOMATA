package gameEngine;

import java.awt.event.KeyEvent;
import java.util.*;

public class KeyHandling {
    private List<Integer> pressedKeys;
    private Map<Integer, Runnable> handledKeys;
    private List<Integer> onceClick;
    private boolean effectue = false;
    public KeyHandling(){
        this.pressedKeys = new LinkedList<>();
        this.handledKeys = new HashMap<>();
        this.onceClick = new ArrayList<>();
    }

    public void keyPressed(int keyCode){
        if (!pressedKeys.contains(keyCode) && !effectue){
            pressedKeys.add(keyCode);
        }
    }

    public void keyReleased(int keyCode){
        pressedKeys.remove(new Integer(keyCode));
        effectue = false;
    }

    public void handleKey(int keyCode, Runnable func, boolean onceClick){
        handledKeys.put(keyCode, func);
        if (onceClick){
            this.onceClick.add(keyCode);
        }
    }

    public void handleKeys(){
        for (Integer pressedKey : pressedKeys) {
            handledKeys.forEach((keyCode, action) -> {
                if (pressedKey.intValue() == keyCode){
                    action.run();
                    for (Integer integer : onceClick) {
                        if (integer.intValue() == keyCode){
                            pressedKeys.remove(new Integer(keyCode));
                            effectue = true;
                        }
                    }
                }
            });
        }
    }
}
