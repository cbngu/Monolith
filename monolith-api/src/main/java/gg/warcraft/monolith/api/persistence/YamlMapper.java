package gg.warcraft.monolith.api.persistence;

import java.io.Reader;

/**
 * This mapper is injectable.
 * <p>
 * YamlMapper maps from a YAML source to a class and vice versa.
 */
public interface YamlMapper extends Mapper {

    @Override
    <T> T parse(String yaml, Class<T> to);

    @Override
    <T> T parse(Reader yaml, Class<T> to);
}
