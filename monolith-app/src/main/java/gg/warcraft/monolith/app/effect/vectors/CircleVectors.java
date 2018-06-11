package gg.warcraft.monolith.app.effect.vectors;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.util.MathUtils;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CircleVectors extends AbstractEffectVectors {
    private final Collection<Vector3fc> vectors;

    @Inject
    public CircleVectors(MathUtils mathUtils, @Assisted float radius, @Assisted int count) {
        this.vectors = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            Vector3f vector = mathUtils.randomVector();
            vector.mul(radius);
            vector.y = 0;
            vectors.add(vector);
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
