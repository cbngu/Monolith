package gg.warcraft.monolith.app.effect.vectors;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LineVectors extends AbstractEffectVectors {
    private final Collection<Vector3fc> vectors;

    @Inject
    public LineVectors(@Assisted("origin") Vector3fc origin, @Assisted("target") Vector3fc target,
                       @Assisted int count) {
        this.vectors = new ArrayList<>();
        Vector3f delta = new Vector3f(target).sub(origin).mul(1f / count);
        for (int i = 0; i <= count; i += 1) {
            Vector3f multipliedDelta = new Vector3f(delta).mul(i);
            vectors.add(new Vector3f(origin).add(multipliedDelta));
        }
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
