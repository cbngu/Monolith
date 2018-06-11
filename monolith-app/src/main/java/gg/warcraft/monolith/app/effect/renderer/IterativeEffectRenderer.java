package gg.warcraft.monolith.app.effect.renderer;

import gg.warcraft.monolith.api.effect.EffectRenderer;
import gg.warcraft.monolith.api.effect.EffectVectors;
import gg.warcraft.monolith.api.effect.Particle;
import gg.warcraft.monolith.api.world.Location;
import org.joml.Vector3fc;

import java.util.Iterator;

public class IterativeEffectRenderer implements EffectRenderer {
    private final Particle particle;
    private final EffectVectors vectors;

    private Iterator<Vector3fc> iterator;

    public IterativeEffectRenderer(Particle particle, EffectVectors vectors) {
        this.particle = particle;
        this.vectors = vectors;
        this.iterator = vectors.iterator();
    }

    @Override
    public void renderAt(Location location) {
        if (!iterator.hasNext()) {
            iterator = vectors.iterator();
        }
        Vector3fc vector = iterator.next();
        Location displayLocation = location.add(vector);
        particle.display(displayLocation);
    }
}
