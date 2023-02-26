package utils;

import world.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Craft {
    private List<Item> ingredients;

    public Craft(Item... registries){
        this.ingredients = new ArrayList<>();
        Arrays.stream(registries).forEach(item -> ingredients.add(item));
    }

    public List<Item> getIngredients() {
        return ingredients;
    }

    public boolean haveIngredients(List<Item> items){
        for (Item ingredient : ingredients) {
            boolean found = false;
            for (Item item : items) {
                if (item.sameItem(ingredient)){
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
