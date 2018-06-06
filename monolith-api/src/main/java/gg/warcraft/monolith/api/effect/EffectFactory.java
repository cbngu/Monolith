package gg.warcraft.monolith.api.effect;

import com.google.inject.name.Named;
import gg.warcraft.monolith.api.util.Duration;
import gg.warcraft.monolith.api.world.Location;

import java.util.function.Supplier;

/**
 * This factory is injectable.
 * <p>
 * EffectFactory serves as a point of entry into the effect implementation. It allows for easy creation of
 * {@code Effect} objects.
 * <p>
 * Effects start running the next tick after creation and will run each tick thereafter (or each period if created as a
 * delayed effect). To stop an effect call one of its cancel methods. To pause an effect cancel it and recreate it anew
 * when it is required again.
 */
public interface EffectFactory {

    /**
     * Creates a new static {@code Effect}.
     * <p>
     * A static {@code Effect} will call all of its effect renderers to display their particles at the given location.
     *
     * @param location The location.
     * @return A new static {@code Effect}. Never null.
     */
    @Named("static")
    Effect createEffect(Location location);

    /**
     * Creates a new dynamic {@code Effect}.
     * <p>
     * A dynamic {@code Effect} will call all of its effect renderers to display their particles at the location
     * currently provided by the supplier.
     *
     * @param location The location supplier.
     * @return A new dynamic {@code Effect}. Never null.
     */
    @Named("dynamic")
    Effect createEffect(Supplier<Location> location);

    /**
     * Creates a new dynamic delayed {@code Effect}.
     * <p>
     * A dynamic delayed {@code Effect} will call all of its effect renderers to display their particles at the location
     * currently provided by the supplier, but only once every period.
     *
     * @param location The location supplier.
     * @param period   The period.
     * @return A new dynamic timed {@code Effect}. Never null.
     */
    @Named("delay")
    Effect createEffect(Supplier<Location> location, Duration period);
}
