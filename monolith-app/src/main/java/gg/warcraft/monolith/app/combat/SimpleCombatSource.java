package gg.warcraft.monolith.app.combat;

import gg.warcraft.monolith.api.combat.CombatSource;

import java.util.UUID;

public class SimpleCombatSource implements CombatSource {
    private final String name;
    private final UUID entityid;

    public SimpleCombatSource(String name, UUID entityId) {
        this.name = name;
        this.entityid = entityId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getEntityId() {
        return entityid;
    }
}
