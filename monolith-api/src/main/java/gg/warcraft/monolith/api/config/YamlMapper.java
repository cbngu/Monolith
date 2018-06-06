package gg.warcraft.monolith.api.config;

import java.io.Reader;

/**
 * This mapper is injectable.
 * <p>
 * A YamlMapper maps from a YAML source to a destination object or vice versa.
 */
public interface YamlMapper extends Mapper {

    @Override
    <T> T from(String yaml, Class<T> to);

    @Override
    <T> T from(Reader yaml, Class<T> to);
}
