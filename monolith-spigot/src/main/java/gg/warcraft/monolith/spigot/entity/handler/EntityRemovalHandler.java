package gg.warcraft.monolith.spigot.entity.handler;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.service.EntityCommandService;
import gg.warcraft.monolith.api.entity.service.EntityRepository;
import gg.warcraft.monolith.spigot.world.Overworld;
import gg.warcraft.monolith.spigot.world.TheEnd;
import gg.warcraft.monolith.spigot.world.TheNether;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class EntityRemovalHandler implements Runnable {
    private final EntityCommandService entityCommandService;
    private final EntityRepository entityRepository;
    private final World overworld;
    private final World theNether;
    private final World theEnd;

    @Inject
    public EntityRemovalHandler(EntityCommandService entityCommandService, EntityRepository entityRepository,
                                @Overworld World overworld, @Nullable @TheNether World theNether,
                                @Nullable @TheEnd World theEnd) {
        this.entityCommandService = entityCommandService;
        this.entityRepository = entityRepository;
        this.overworld = overworld;
        this.theNether = theNether;
        this.theEnd = theEnd;
    }

    private void purgeWorld(World world, Set<UUID> markedForRemoval) {
        Set<UUID> entityIds = world.getEntities().stream()
                .filter(LivingEntity.class::isInstance)
                .map(Entity::getUniqueId)
                .collect(Collectors.toSet());
        Set<UUID> toRemove = Sets.intersection(entityIds, markedForRemoval);
        entityRepository.delete(Lists.newArrayList(toRemove));
        toRemove.forEach(entityCommandService::removeEntity);
    }

    @Override
    public void run() {
        Set<UUID> markedForRemoval = entityRepository.getMarkedForRemoval();
        purgeWorld(overworld, markedForRemoval);
        if (theNether != null) {
            purgeWorld(theNether, markedForRemoval);
        }
        if (theEnd != null) {
            purgeWorld(theEnd, markedForRemoval);
        }
    }
}
