package gg.warcraft.monolith.api.effect;

import com.google.inject.name.Named;
import gg.warcraft.monolith.api.util.ColorHue;

/**
 * This factory is injectable.
 * <p>
 * ParticleFactory serves as a point of entry into the effect implementation. It allows for easy creation of
 * {@code Particle} objects.
 */
public interface ParticleFactory {

    /**
     * Creates a new color based particle.
     *
     * @param type  The particle type.
     * @param color The color.
     * @return A new color based particle. Never null.
     */
    @Named("color")
    Particle createColorParticle(ParticleType type, ColorHue color);

    /**
     * Creates a new multi-particle.
     * <p>
     * Multi-particles are a collection of particles that can be passed around like any normal single particle. A multi-
     * particle will step over its collection of particles when asked to display itself to determine which particle to
     * render this time.
     *
     * @param particles The particles.
     * @return A new multi-particle. Never null.
     */
    @Named("multi")
    Particle createMultiParticle(Particle... particles);

    /**
     * Creates a new simple particle.
     *
     * @param type The particle type.
     * @return A new simple particle.
     */
    @Named("simple")
    Particle createSimpleParticle(ParticleType type);

    /**
     * Creates a new speed emitting based particle.
     *
     * @param type   The particle type.
     * @param speed  The speed.
     * @param amount The amount of emitted particles.
     * @return A new speed emitting based particle. Never null.
     */
    @Named("speed")
    Particle createSpeedParticle(ParticleType type, float speed, int amount);
}
