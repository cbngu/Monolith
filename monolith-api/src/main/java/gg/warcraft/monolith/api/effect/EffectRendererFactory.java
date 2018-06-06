package gg.warcraft.monolith.api.effect;

import com.google.inject.name.Named;

/**
 * This factory is injectable.
 * <p>
 * EffectRendererFactory serves as a point of entry into the effect implementation. It allows for easy creation of
 * {@code EffectRenderer} objects.
 */
public interface EffectRendererFactory {

    /**
     * Creates a new iterative effect renderer with the given particle and effect vectors.
     * <p>
     * An iterative effect renderer will incrementally display its particle at the next offset location of the vectors
     * every time it is asked to render at a location.
     *
     * @param particle The particle.
     * @param vectors  The effect vectors.
     * @return A new iterative effect renderer with the given particle and effect vectors. Never null.
     */
    @Named("iterative")
    EffectRenderer createIterativeEffectRenderer(Particle particle, EffectVectors vectors);

    /**
     * Creates a new simple effect renderer with the given particle and effect vectors.
     * <p>
     * A simple effect renderer will display its particle at all of the offset locations of the vectors every time it is
     * asked to render at a location.
     *
     * @param particle The particle.
     * @param vectors  The effect vectors.
     * @return A new simple effect renderer with the given particle and effect vectors. Never null.
     */
    @Named("simple")
    EffectRenderer createSimpleEffectRenderer(Particle particle, EffectVectors vectors);
}
