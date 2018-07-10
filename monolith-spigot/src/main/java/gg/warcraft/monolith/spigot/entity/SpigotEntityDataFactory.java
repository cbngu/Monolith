package gg.warcraft.monolith.spigot.entity;

import org.bukkit.entity.LivingEntity;

public interface SpigotEntityDataFactory {

    SpigotEntityData create(LivingEntity entity);
}
