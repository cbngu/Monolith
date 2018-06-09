package gg.warcraft.monolith.app.entity.player;

import gg.warcraft.monolith.api.entity.Faction;
import gg.warcraft.monolith.api.entity.player.PlayerData;

import java.util.UUID;

public class SimplePlayerData implements PlayerData {
    private final UUID playerId;
    private final String minecraftName;
    private final String displayName;
    private final long timeOfConnect;
    private final long timeOfFirstConnect;
    private final long timePlayed;
    private final Faction faction;

    public SimplePlayerData(UUID playerId, String minecraftName, String displayName, long timeOfConnect,
                            long timeOfFirstConnect, long timePlayed, Faction faction) {
        this.playerId = playerId;
        this.minecraftName = minecraftName;
        this.displayName = displayName;
        this.timeOfConnect = timeOfConnect;
        this.timeOfFirstConnect = timeOfFirstConnect;
        this.timePlayed = timePlayed;
        this.faction = faction;
    }

    @Override
    public UUID getPlayerId() {
        return playerId;
    }

    @Override
    public UUID getEntityId() {
        return playerId;
    }

    @Override
    public String getMinecraftName() {
        return minecraftName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public long getTimeOfConnect() {
        return timeOfConnect;
    }

    @Override
    public long getTimeOfFirstConnect() {
        return timeOfFirstConnect;
    }

    @Override
    public long getTimePlayed() {
        return timePlayed;
    }

    @Override
    public Faction getFaction() {
        return faction;
    }
}