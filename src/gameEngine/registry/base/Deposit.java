package gameEngine.registry.base;

import gameEngine.Automata;
import gameEngine.registry.Registrable;
import gameEngine.rendering.Texture;
import world.Tile;

public abstract class Deposit extends Registrable {
    private Texture texture;
    public Deposit(String registryName) {
        super(registryName);
        this.texture = new Texture(Automata.TEXTURE_PATH+"tiles/deposit/"+registryName+".png", Tile.RENDER_SIZE);
    }

    public Texture getTexture() {
        return texture;
    }
}
