package gg.warcraft.monolith.api.config;

import java.io.Reader;

/**
 * This mapper is injectable.
 * <p>
 * JsonMapper maps from a JSON source to a class and vice versa.
 */
public interface JsonMapper extends Mapper {

    @Override
    <T> T parse(String json, Class<T> to);

    @Override
    <T> T parse(Reader json, Class<T> to);
}
