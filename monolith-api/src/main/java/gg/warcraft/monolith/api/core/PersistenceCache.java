package gg.warcraft.monolith.api.core;

public interface PersistenceCache {

    String get(String key);

    void save(String key, String value);

    void delete(String key);

    void clear();
}
