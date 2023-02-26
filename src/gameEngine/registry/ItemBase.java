package gameEngine.registry;

import gameEngine.rendering.Texture;

public abstract class ItemBase extends Registrable{
    private Texture texture;

    public ItemBase(String registryName) {
        super(registryName);
        this.texture = new Texture("assets/textures/items/"+registryName+".png");
    }

    public ItemBase(String registryName, Texture texture) {
        super(registryName);
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }
}
