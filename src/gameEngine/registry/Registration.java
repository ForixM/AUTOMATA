package gameEngine.registry;

import gameEngine.registry.deposits.Coal;
import gameEngine.registry.items.Stick;
import gameEngine.registry.tiles.Extractor;
import gameEngine.registry.tiles.Grass;
import gameEngine.registry.tiles.Sand;
import gameEngine.registry.tiles.Water;

import java.util.HashMap;

public class Registration {
    public static HashMap<String, RegistryObject> registered = new HashMap<>();

    // TILES REGISTRATION
    public static RegistryObject<Grass> grass = registerObject(new Grass("grass"));
    public static RegistryObject<Sand> sand = registerObject(new Sand("sand"));
    public static RegistryObject<Water> water = registerObject(new Water("water"));

    public static RegistryObject<Extractor> extractor = registerObject(new Extractor("extractor"));

    // DEPOSIT REGISTRATION

    public static RegistryObject<Coal> coal = registerObject(new Coal("coal"));

    //ITEMS REGISTRATION
    public static RegistryObject<Stick> stick = registerObject(new Stick("stick"));

    private static <T extends Registrable> RegistryObject<T> registerObject(T object){
        RegistryObject<T> toReturn = new RegistryObject<>(object);
        registered.put(object.getRegistryName(), toReturn);
        return toReturn;
    }

    public static <T extends Registrable> RegistryObject<T> getRegistryObjectByRegistryName(String registryName){
        if (registered.containsKey(registryName)){
            return registered.get(registryName);
        }
        return null;
    }
}
