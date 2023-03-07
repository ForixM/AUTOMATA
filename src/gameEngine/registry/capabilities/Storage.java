package gameEngine.registry.capabilities;

import world.Item;

public abstract class Storage {
    private Item[] container;

    public Storage(int capacity){
        this.container = new Item[capacity];
        for (int i = 0; i < container.length; i++) {
            container[i] = Item.EMPTY;
        }
    }

    public void insert(Item toInsert){
        for (Item t : container) {
            if (t != Item.EMPTY && t.sameItem(toInsert)){
                t.grow(toInsert.getCount());
                return;
            }
        }
        for (int i = 0; i < container.length; i++) {
            if (container[i] == Item.EMPTY){
                container[i] = toInsert;
                return;
            }
        }
    }

    public Item extract(int slot){
        Item toReturn = container[slot];
        container[slot] = Item.EMPTY;
        return toReturn;
//        if (slot < container.size()){
//            Item toExtract = container.remove(slot);
//            return toExtract;
//        }
//        return null;
    }

    public Item extract(String registryName){
        for (int i = 0; i < container.length; i++) {
            if (container[i] != Item.EMPTY && container[i].getBase().getRegistryName().equals(registryName)){
                Item toReturn = container[i];
                container[i] = Item.EMPTY;
                return toReturn;
            }
        }
//        for (Item t : container) {
//            if (t != Item.EMPTY && t.getBase().getRegistryName().equals(registryName)){
//                container.remove(t);
//                return t;
//            }
//        }
        return Item.EMPTY;
    }

    public boolean contains(Item item){
        for (Item t : container) {
            if (t.sameItem(item)){
                return true;
            }
        }
        return false;
    }

    public boolean containsAtLeast(Item item){
        for (Item t : container) {
            if (t.sameItem(item) && t.getCount() >= item.getCount()){
                return true;
            }
        }
        return false;
    }

    public Item[] getContainer() {
        return container;
    }

    public int getCapacity() {
        return container.length;
    }
}
