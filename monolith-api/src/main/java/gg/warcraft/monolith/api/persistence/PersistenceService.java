package gg.warcraft.monolith.api.persistence;

import java.util.List;
import java.util.Map;

/**
 * This service is injectable.
 * <p>
 * The PersistenceService serves as a point of entry into the persistence module implementation. It provides methods to
 * get and set data in the store. Redis is currently the only supported implementation of this interface.
 */
public interface PersistenceService {

    /**
     * @param key The key of the value to retrieve. Can not be null or empty.
     * @return The value. Can be null or empty.
     */
    String get(String key);

    /**
     * @param key   The key to set the value at. Can not be null or empty.
     * @param value The value. Can be null or empty.
     */
    void set(String key, String value);

    /**
     * @param key The key of the value list to retrieve. Can not be null or empty.
     * @return The value list. Can be null or empty.
     */
    List<String> getList(String key);

    /**
     * Pushes a value onto the list at key. Care should be taken that this method will overwrite the existing list in
     * its entirety with the new values provided.
     *
     * @param key    The key to set the value list at. Can not be nul or empty.
     * @param values The value list. Can be null or empty.
     */
    void setList(String key, List<String> values);

    /**
     * @param key   The key of the list to push the value onto. Can not be nul or empty.
     * @param value The value. Can be null or empty.
     */
    void pushList(String key, String value);

    /**
     * @param key The key of the value map to retrieve. Can not be null or empty.
     * @return The value map. Can be null or empty.
     */
    Map<String, String> getMap(String key);

    /**
     * @param key    The key to set the value map at. Can not be nul or empty.
     * @param values The value map. Can be null or empty.
     */
    void setMap(String key, Map<String, String> values);

    /**
     * @param key The key to delete any associated value or value map for. Can not be null or empty.
     */
    void delete(String key);

    /**
     * @param keyPrefix The prefix. Can not be null or empty.
     * @return All keys matching the prefix. Never null, but can be empty. Items are never null or empty.
     */
    List<String> getAllKeys(String keyPrefix);
}
