package gg.warcraft.monolith.app.world.portal;

import gg.warcraft.monolith.api.effect.Effect;
import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.world.location.Location;
import gg.warcraft.monolith.api.world.location.OrientedLocation;
import gg.warcraft.monolith.api.world.portal.Portal;

import java.util.function.Predicate;

public class SimplePortal implements Portal {
    private final Location entryLocation;
    private final OrientedLocation exitLocation;
    private final Predicate<Entity> predicate;
    private final Effect effect;

    public SimplePortal(Location entryLocation, OrientedLocation exitLocation, Predicate<Entity> predicate, Effect effect) {
        this.entryLocation = entryLocation;
        this.exitLocation = exitLocation;
        this.predicate = predicate;
        this.effect = effect;
    }

    @Override
    public Location getEntryLocation() {
        return entryLocation;
    }

    @Override
    public OrientedLocation getExitLocation() {
        return exitLocation;
    }

    @Override
    public Predicate<Entity> getPredicate() {
        return predicate;
    }

    @Override
    public Effect getEffect() {
        return effect;
    }
}
