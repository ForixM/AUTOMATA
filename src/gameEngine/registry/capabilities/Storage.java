package gameEngine.registry.capabilities;

import world.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage<T extends Item> {
    private List<T> container;
    private int capacity;

    public Storage(int capacity){
        this.capacity = capacity;
        this.container = new ArrayList<>();
    }

    public void insert(T toInsert){
        if (container.size() < capacity){
            container.add(toInsert);
        }
    }

    public T extract(int slot){
        if (slot < container.size()){
            T toExtract = container.remove(slot);
            return toExtract;
        }
        return null;
    }

    public T extract(String registryName){
        for (T t : container) {
            if (t.getBase().getRegistryName().equals(registryName)){
                container.remove(t);
                return t;
            }
        }
        return null;
    }

    public boolean contains(Item item){
        for (T t : container) {
            if (t.sameItem(item)){
                return true;
            }
        }
        return false;
    }

    public boolean containsAtLeast(Item item){
        for (T t : container) {
            if (t.sameItem(item) && t.getCount() >= item.getCount()){
                return true;
            }
        }
        return false;
    }

    public List<T> getContainer() {
        return container;
    }
}
