package gameEngine.registry.base;

import gameEngine.Automata;
import gameEngine.registry.Registrable;
import gameEngine.rendering.Texture;
import world.Item;
import world.Tile;

public abstract class Deposit extends Registrable {
    private Texture texture;
    private ItemBase loot;
    public Deposit(String registryName) {
        super(registryName);
        this.texture = new Texture(Automata.TEXTURE_PATH+"tiles/deposit/"+registryName+".png", Tile.RENDER_SIZE);
        this.loot = new ItemBase(registryName) {};
    }

    public Texture getTexture() {
        return texture;
    }

    public ItemBase getLoot() {
        return loot;
    }
}
