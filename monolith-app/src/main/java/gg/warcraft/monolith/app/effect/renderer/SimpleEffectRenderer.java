package gg.warcraft.monolith.app.effect.renderer;

import gg.warcraft.monolith.api.effect.EffectRenderer;
import gg.warcraft.monolith.api.effect.EffectVectors;
import gg.warcraft.monolith.api.effect.Particle;
import gg.warcraft.monolith.api.world.Location;

public class SimpleEffectRenderer implements EffectRenderer {
    private final Particle particle;
    private final EffectVectors vectors;

    public SimpleEffectRenderer(Particle particle, EffectVectors vectors) {
        this.particle = particle;
        this.vectors = vectors;
    }

    @Override
    public void renderAt(Location location) {
        vectors.iterator().forEachRemaining(vector -> {
            Location displayLocation = location.add(vector);
            particle.display(displayLocation);
        });
    }
}
