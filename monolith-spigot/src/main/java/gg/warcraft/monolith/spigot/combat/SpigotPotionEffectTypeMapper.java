package gg.warcraft.monolith.spigot.combat;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.combat.PotionEffectType;
import gg.warcraft.monolith.api.combat.PotionEffectTypeUtils;

public class SpigotPotionEffectTypeMapper {
    private final PotionEffectTypeUtils potionEffectTypeUtils;

    @Inject
    public SpigotPotionEffectTypeMapper(PotionEffectTypeUtils potionEffectTypeUtils) {
        this.potionEffectTypeUtils = potionEffectTypeUtils;
    }

    public PotionEffectType map(org.bukkit.potion.PotionEffectType type) {
        return potionEffectTypeUtils.getType(type.getId());
    }

    public org.bukkit.potion.PotionEffectType map(PotionEffectType type) {
        return org.bukkit.potion.PotionEffectType.getById(type.getId());
    }
}
