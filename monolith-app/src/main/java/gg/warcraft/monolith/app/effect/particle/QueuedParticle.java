package gg.warcraft.monolith.app.effect.particle;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.monolith.api.effect.Particle;
import gg.warcraft.monolith.api.world.location.Location;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QueuedParticle implements Particle {
    private final List<Particles> particles;

    private int currentParticle;
    private int currentCount;

    @Inject
    public QueuedParticle(@Assisted LinkedHashMap<Particle, Integer> particles) {
        this.particles = new ArrayList<>();
        particles.forEach((particle, count) -> this.particles.add(new Particles(particle, count)));
        this.currentParticle = 0;
        this.currentCount = 0;
    }

    @Override
    public void display(Location location) {
        Particle particle = getParticle();
        if (particle != null) {
            particle.display(location);
        }
    }

    private Particle getParticle() {
        if (currentParticle >= particles.size()) {
            return null;
        }

        Particles collection = particles.get(currentParticle);
        currentCount += 1;
        if (currentCount >= collection.getCount()) {
            currentParticle += 1;
            currentCount = 0;
            if (currentParticle < particles.size()) {
                collection = particles.get(currentParticle);
            } else {
                return null;
            }
        }

        return collection.getParticle();
    }

    private class Particles {
        private final Particle particle;
        private final int count;

        public Particles(Particle particle, int count) {
            this.particle = particle;
            this.count = count;
        }

        public Particle getParticle() {
            return particle;
        }

        public int getCount() {
            return count;
        }
    }
}
