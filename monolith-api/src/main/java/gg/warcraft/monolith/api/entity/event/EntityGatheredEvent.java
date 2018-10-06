package gg.warcraft.monolith.api.entity.event;

import java.util.UUID;

import gg.warcraft.monolith.api.entity.Entity;

public interface EntityGatheredEvent {

    Entity getGatheredEntity();

    UUID getPlayerId();
}
