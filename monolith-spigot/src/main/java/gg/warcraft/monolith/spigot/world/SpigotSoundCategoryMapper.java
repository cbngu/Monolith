package gg.warcraft.monolith.spigot.world;

import gg.warcraft.monolith.api.world.SoundCategory;

public class SpigotSoundCategoryMapper {

    public org.bukkit.SoundCategory map(SoundCategory category) {
        return org.bukkit.SoundCategory.valueOf(category.name());
    }

    public SoundCategory map(org.bukkit.SoundCategory category) {
        return SoundCategory.valueOf(category.name());
    }
}
