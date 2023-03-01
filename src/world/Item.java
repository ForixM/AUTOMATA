package world;

import gameEngine.registry.ItemBase;

public class Item {
    private ItemBase base;
    private int count;
    public Item(ItemBase itemBase, int count){
        this.base = itemBase;
        this.count = count;
    }

    public ItemBase getBase() {
        return base;
    }

    public int getCount() {
        return count;
    }

    public boolean sameItem(Item item){
        return item.getBase().getRegistryName().equals(item.getBase().getRegistryName());
    }

    @Override
    public String toString() {
        return "{item="+getBase().getRegistryName()+", cout="+count+"}";
    }
}
