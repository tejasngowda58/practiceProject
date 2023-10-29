package practice.LLD.DesignPatterns.PrototypeAndRegistry;

import java.util.HashMap;
import java.util.Map;

public abstract class Registry<T> {
    private Map<String, T> registry = new HashMap<>();

    public void register(String key, T value){
        registry.put(key, value);
    }

    public T get(String key){
        return registry.get(key);
    }
}
