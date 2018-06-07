package gg.warcraft.monolith.app.effect.vectors;

import org.joml.Vector3fc;

import java.util.Collection;
import java.util.Iterator;

public class SimpleEffectVectors extends AbstractEffectVectors {
    private final Collection<Vector3fc> vectors;

    public SimpleEffectVectors(Collection<Vector3fc> vectors) {
        this.vectors = vectors;
    }

    @Override
    public Collection<Vector3fc> getVectors() {
        return vectors;
    }

    @Override
    public Iterator<Vector3fc> iterator() {
        return vectors.iterator();
    }
}
