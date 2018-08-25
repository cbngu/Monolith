package gg.warcraft.monolith.app.combat;

import gg.warcraft.monolith.api.combat.PotionEffectType;
import gg.warcraft.monolith.api.combat.PotionEffectTypeUtils;

import java.util.HashMap;
import java.util.Map;

public class DefaultPotionEffectTypeUtils implements PotionEffectTypeUtils {
    private static final Map<Integer, PotionEffectType> types = new HashMap<>();

    static {
        for (PotionEffectType type : PotionEffectType.values()) {
            types.put(type.getId(), type);
        }
    }

    @Override
    public PotionEffectType getType(int id) {
        return types.get(id);
    }
}
