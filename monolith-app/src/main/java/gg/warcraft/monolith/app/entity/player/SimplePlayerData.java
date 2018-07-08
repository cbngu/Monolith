package gg.warcraft.monolith.app.entity.player;

import gg.warcraft.monolith.api.entity.Team;
import gg.warcraft.monolith.api.entity.player.PlayerData;
import gg.warcraft.monolith.app.entity.SimpleEntityData;

import java.util.UUID;

public class SimplePlayerData extends SimpleEntityData implements PlayerData {
    private final UUID playerId;
    private final String minecraftName;
    private final String displayName;
    private final long timeOfConnect;
    private final long timeOfFirstConnect;
    private final long timeLastSeen;
    private final long timePlayed;

    public SimplePlayerData(UUID playerId, String minecraftName, String displayName, long timeOfConnect,
                            long timeOfFirstConnect, long timeLastSeen, long timePlayed, Team team) {
        super(playerId, team);
        this.playerId = playerId;
        this.minecraftName = minecraftName;
        this.displayName = displayName;
        this.timeOfConnect = timeOfConnect;
        this.timeOfFirstConnect = timeOfFirstConnect;
        this.timeLastSeen = timeLastSeen;
        this.timePlayed = timePlayed;
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
    public long getTimeLastSeen() {
        return timeLastSeen;
    }

    @Override
    public long getTimePlayed() {
        return timePlayed;
    }
}
