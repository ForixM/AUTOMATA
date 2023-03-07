package world;

import gameEngine.registry.base.ItemBase;

public class Item {
    private ItemBase base;
    private int count;
    public static int RENDER_SIZE = 500;
    public static final Item EMPTY = new Item(null, -1);
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
        return base.getRegistryName().equals(item.getBase().getRegistryName());
    }

    public int grow(int amount){
        count += amount;
        return 0;
    }

    @Override
    public String toString() {
        return "{item="+getBase().getRegistryName()+", cout="+count+"}";
    }
}
