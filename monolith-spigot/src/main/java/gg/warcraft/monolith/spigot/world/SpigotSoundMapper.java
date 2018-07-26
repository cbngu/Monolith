package gg.warcraft.monolith.spigot.world;

import gg.warcraft.monolith.api.world.Sound;

public class SpigotSoundMapper {

    public org.bukkit.Sound map(Sound sound) {
        return org.bukkit.Sound.valueOf(sound.name());
    }

    public Sound map(org.bukkit.Sound sound) {
        return Sound.valueOf(sound.name());
    }
}
