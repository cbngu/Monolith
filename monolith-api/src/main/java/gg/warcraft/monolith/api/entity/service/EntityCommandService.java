package gg.warcraft.monolith.api.entity.service;

import gg.warcraft.monolith.api.entity.EntityType;
import gg.warcraft.monolith.api.entity.Faction;
import gg.warcraft.monolith.api.util.Duration;
import gg.warcraft.monolith.api.world.Location;
import gg.warcraft.monolith.api.world.PotionEffect;
import gg.warcraft.monolith.api.world.PotionType;
import org.joml.Vector3fc;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The EntityCommandService serves as a point of entry into the entity module implementation. It provides a plethora of
 * methods to interact with the physics of an {@code Entity}.
 */
public interface EntityCommandService {

    /**
     * @param entityId The id of the entity.
     * @param velocity The new velocity of the entity.
     */
    void setVelocity(UUID entityId, Vector3fc velocity);

    /**
     * @param entityId The id of the entity.
     * @param faction  The new faction of the entity.
     */
    void setFaction(UUID entityId, Faction faction);

    /**
     * @param entityId The id of the entity. Can not be null.
     * @param effect   The potion effect to add to the entity. Can not be null.
     */
    void addPotionEffect(UUID entityId, PotionEffect effect);

    /**
     * @param entityId The id of the entity. Can not be null.
     * @param effect   The potion effect to remove from the entity. Can not be null.
     */
    void removePotionEffect(UUID entityId, PotionType type);

    /**
     * @param type          The type of entity to spawn. Can not be null.
     * @param spawnLocation The location to spawn the entity at. Can not be null.
     */
    void spawnEntity(EntityType entityType, Location spawnLocation);

    /**
     * @param entityId The id of the entity. Can not be null.
     * @param location The location to teleport the entity to. Can not be null.
     */
    void teleport(UUID entityId, Location location);

    /**
     * Prevents an entity from jumping for a duration.
     *
     * @param entityId The id of the entity.
     * @param duration The duration.
     */
    void heavy(UUID entityId, Duration duration);

    /**
     * Prevents an entity from moving for a duration.
     *
     * @param entityId The id of the entity.
     * @param duration The duration.
     */
    void freeze(UUID entityId, Duration duration);

    /**
     * Knocks an entity back a distance in a direction.
     *
     * @param entityId  The id of the entity.
     * @param direction The direction.
     * @param distance  The distance in blocks.
     */
    void knockback(UUID entityId, Vector3fc direction, float distance);

    /**
     * Knocks an entity back a distance from a point of impact.
     *
     * @param entityId  The id of the entity.
     * @param direction The direction.
     * @param distance  The distance in blocks.
     */
    void knockback(UUID entityId, Location source, float distance);

    /**
     * Knocks an entity up a distance.
     *
     * @param entityId The id of the entity.
     * @param distance The distance in blocks.
     */
    void knockup(UUID entityId, float distance);

    /**
     * Causes an entity to leap a distance in a direction.
     *
     * @param entityId  The id of the entity.
     * @param direction The direction.
     * @param distance  The distance in blocks.
     */
    void leap(UUID entityId, Vector3fc direction, float distance);

    /**
     * Sucks an entity towards a point.
     *
     * @param entityId The id of the entity.
     * @param source   The point.
     * @param strength The strength.
     */
    void vacuum(UUID entityId, Location source, float strength);
}
