package gg.warcraft.monolith.app.combat;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.combat.CombatSource;

import java.util.UUID;

public class SimpleCombatSource implements CombatSource {
    private final String name;
    private final UUID entityId;

    @Inject
    public SimpleCombatSource(@Assisted String name, @Assisted UUID entityId) {
        this.name = name;
        this.entityId = entityId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getEntityId() {
        return entityId;
    }
}
