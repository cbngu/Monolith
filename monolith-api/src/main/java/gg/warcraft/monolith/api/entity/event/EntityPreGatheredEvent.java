package gg.warcraft.monolith.api.entity.event;

import java.util.UUID;

import gg.warcraft.monolith.api.entity.Entity;

public interface EntityPreGatheredEvent {

    Entity getGatheredEntity();

    UUID getPlayerId();
}
