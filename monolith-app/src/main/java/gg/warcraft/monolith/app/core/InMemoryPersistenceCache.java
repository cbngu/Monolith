package gg.warcraft.monolith.app.core;

import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.PersistenceCache;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class InMemoryPersistenceCache implements PersistenceCache {
    private final Map<String, String> cache;

    public InMemoryPersistenceCache() {
        this.cache = new HashMap<>();
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }

    @Override
    public void save(String key, String value) {
        cache.put(key, value);
    }

    @Override
    public void delete(String key) {
        cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }
}
