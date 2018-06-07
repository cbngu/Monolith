package gg.warcraft.monolith.app.effect.vectors;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.joml.Vector3fc;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PointVector extends AbstractEffectVectors {
    private final Collection<Vector3fc> vectors;

    @Inject
    public PointVector(@Assisted Vector3fc point) {
        this.vectors = List.of(point);
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
