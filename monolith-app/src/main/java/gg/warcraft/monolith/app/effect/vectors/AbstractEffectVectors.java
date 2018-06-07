package gg.warcraft.monolith.app.effect.vectors;

import gg.warcraft.monolith.api.effect.EffectVectors;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractEffectVectors implements EffectVectors {

    @Override
    public EffectVectors addOffset(Vector3fc offset) {
        Collection<Vector3fc> vectors = getVectors().stream()
                .map(vector -> new Vector3f(vector).add(offset))
                .collect(Collectors.toList());
        return new SimpleEffectVectors(vectors);
    }

    @Override
    public EffectVectors rotateAroundAxisX(float angle) {
        Collection<Vector3fc> vectors = getVectors().stream()
                .map(vector -> new Vector3f(vector).rotateX(angle))
                .collect(Collectors.toList());
        return new SimpleEffectVectors(vectors);
    }

    @Override
    public EffectVectors rotateAroundAxisY(float angle) {
        Collection<Vector3fc> vectors = getVectors().stream()
                .map(vector -> new Vector3f(vector).rotateY(angle))
                .collect(Collectors.toList());
        return new SimpleEffectVectors(vectors);
    }

    @Override
    public EffectVectors rotateAroundAxisZ(float angle) {
        Collection<Vector3fc> vectors = getVectors().stream()
                .map(vector -> new Vector3f(vector).rotateZ(angle))
                .collect(Collectors.toList());
        return new SimpleEffectVectors(vectors);
    }
}
