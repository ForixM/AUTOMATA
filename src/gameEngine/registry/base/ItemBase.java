package gameEngine.registry.base;

import gameEngine.registry.Registrable;
import gameEngine.rendering.Texture;
import world.Item;
import world.Tile;

public abstract class ItemBase extends Registrable {
    private Texture texture;

    public ItemBase(String registryName) {
        super(registryName);
        this.texture = new Texture("assets/textures/items/"+registryName+".png", Item.RENDER_SIZE);
    }

    public ItemBase(String registryName, Texture texture) {
        super(registryName);
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }
}
