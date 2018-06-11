package gg.warcraft.monolith.app.effect.vectors;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RingVectors extends AbstractEffectVectors {
    private static final float TWO_PI = 2 * (float) Math.PI;

    private final Collection<Vector3fc> vectors;

    @Inject
    public RingVectors(@Assisted float radius, @Assisted int count) {
        this.vectors = new ArrayList<>(count);
        float angle = 0;
        float delta = TWO_PI / count;
        for (int i = 0; i < count; ++i) {
            float x = (float) Math.cos(angle) * radius;
            float z = (float) Math.sin(angle) * radius;
            vectors.add(new Vector3f(x, 0, z));
            angle += delta;
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
