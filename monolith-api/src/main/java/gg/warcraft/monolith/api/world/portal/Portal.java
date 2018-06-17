package gg.warcraft.monolith.api.world.portal;

import gg.warcraft.monolith.api.effect.Effect;
import gg.warcraft.monolith.api.entity.Entity;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.OrientedLocation;

import java.util.function.Predicate;

public interface Portal {

    Location getEntryLocation();

    OrientedLocation getExitLocation();

    Predicate<Entity> getPredicate();

    Effect getEffect();
}
