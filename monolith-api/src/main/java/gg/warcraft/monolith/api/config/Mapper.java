package gg.warcraft.monolith.api.config;

import java.io.Reader;

/**
 * A Mapper maps from a text source to a destination object or vice versa.
 */
public interface Mapper {

    /**
     * Parses the text source to an object of the specified class.
     *
     * @param source The text source.
     * @param to     The class of the destination object.
     * @param <T>    The type of the destination class.
     * @return The object.
     */
    <T> T from(String source, Class<T> to);

    /**
     * Parses the reader source to an object of the specified class.
     *
     * @param source The reader source.
     * @param to     The class of the destination object.
     * @param <T>    The type of the destination class.
     * @return The object.
     */
    <T> T from(Reader source, Class<T> to);

    /**
     * Stringifies the given object according to the implementation.
     *
     * @param object The object to map.
     * @return The stringified object.
     */
    String to(Object object);
}
