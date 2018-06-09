package gg.warcraft.monolith.api.config;

import java.io.Reader;

/**
 * A Mapper maps from a text source to a class and vice versa.
 */
public interface Mapper {

    /**
     * @param source The string to parse.
     * @param to     The class to map to.
     * @param <T>    The type of the class.
     * @return The result of mapping the source to the class. Can be null.
     */
    <T> T parse(String source, Class<T> to);

    /**
     * @param source The source to parse.
     * @param to     The class to map to.
     * @param <T>    The type of the class.
     * @return The result of mapping the source to the class. Can be null.
     */
    <T> T parse(Reader source, Class<T> to);

    /**
     * @param object The object.
     * @return The stringified object.
     */
    String stringify(Object object);
}
