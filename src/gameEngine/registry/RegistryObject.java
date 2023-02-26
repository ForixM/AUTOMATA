package gameEngine.registry;

public class RegistryObject<T extends Registrable> {
    private T registered;
    public RegistryObject(T registered){
        this.registered = registered;
    }

    public T get() {
        return registered;
    }
}
