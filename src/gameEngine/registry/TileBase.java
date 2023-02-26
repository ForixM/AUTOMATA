package gameEngine.registry;

import gameEngine.rendering.Texture;

public abstract class TileBase extends Registrable {
    private Texture texture;
    private ItemBase item;
    public TileBase(String registryName){
        super(registryName);
        this.texture = new Texture("assets/textures/tiles/"+registryName+".png");
        this.item = new ItemBase(registryName) {
            @Override
            public String getRegistryName() {
                return super.getRegistryName();
            }
        };
    }

    public Texture getTexture() {
        return texture;
    }

    public ItemBase getItem(){
        return item;
    }
}