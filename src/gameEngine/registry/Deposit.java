package gameEngine.registry;

import gameEngine.Automata;
import gameEngine.rendering.Texture;

public abstract class Deposit extends Registrable {
    private Texture texture;
    public Deposit(String registryName) {
        super(registryName);
        this.texture = new Texture(Automata.TEXTURE_PATH+"tiles/deposit/"+registryName+".png");
    }

    public Texture getTexture() {
        return texture;
    }
}
