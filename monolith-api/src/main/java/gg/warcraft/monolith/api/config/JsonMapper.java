package gg.warcraft.monolith.api.config;

import java.io.Reader;

/**
 * This mapper is injectable.
 * <p>
 * A JsonMapper maps from a JSON source to a destination object or vice versa.
 */
public interface JsonMapper extends Mapper {

    @Override
    <T> T from(String json, Class<T> to);

    @Override
    <T> T from(Reader json, Class<T> to);
}
