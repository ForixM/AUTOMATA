package gameEngine.registry;

public abstract class Registrable {
    protected String registryName;
    public Registrable(String registryName){
        this.registryName = registryName;
    }

    public String getRegistryName() {
        return registryName;
    }
}
