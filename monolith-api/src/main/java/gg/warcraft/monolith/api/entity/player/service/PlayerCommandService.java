package gg.warcraft.monolith.api.entity.player.service;

import gg.warcraft.monolith.api.entity.player.Currency;

import java.util.UUID;

/**
 * This service is injectable.
 * <p>
 * The PlayerCommandService serves as a point of entry into the entity module implementation. It provides a method to
 * trigger an update of the total play time of a {@code Player}.
 */
public interface PlayerCommandService {

    void addCurrency(UUID playerId, Currency currency, int amount);

    void removeCurrency(UUID playerId, Currency currency, int amount);

    /**
     * @param playerId The id of the player to update. Can not be null.
     */
    void update(UUID playerId);

    /**
     * @param playerId the id of the player. Can not be null.
     * @param message  The message to send. Can not be null or empty.
     */
    void sendMessage(UUID playerId, String message);

    /**
     * Sends a server notification to the player. Server notifications are yellow messages prefixed with '[SERVER]'.
     *
     * @param playerId     the id of the player. Can not be null.
     * @param notification The notification to send. Can not be null or empty.
     */
    void sendNotification(UUID playerId, String notification);
}
