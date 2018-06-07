package gg.warcraft.monolith.app.effect.vectors;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.effect.EffectVectors;
import org.joml.Vector3fc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EffectAnimation extends AbstractEffectVectors {
    private static final Iterator<Vector3fc> EMPTY_ITERATOR = List.<Vector3fc>of().iterator();

    private final List<EffectVectors> vectors;

    private Iterator<EffectVectors> iterator;

    @Inject
    public EffectAnimation(@Assisted EffectVectors... vectors) {
        this.vectors = Arrays.asList(vectors);
        this.iterator = this.vectors.iterator();
    }

    @Override
    public Collection<Vector3fc> getVectors() {
        return vectors.stream()
                .flatMap(effectVectors -> effectVectors.getVectors().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Vector3fc> iterator() {
        if (!iterator.hasNext()) {
            iterator = this.vectors.iterator();
        }
        if (iterator.hasNext()) {
            return iterator.next().iterator();
        } else {
            return EMPTY_ITERATOR;
        }
    }
}
