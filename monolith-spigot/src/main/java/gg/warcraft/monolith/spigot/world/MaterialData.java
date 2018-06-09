package gg.warcraft.monolith.spigot.world;

import org.bukkit.Material;

public class MaterialData {
    private final Material material;
    private final byte data;

    public MaterialData(Material material, int data) {
        this.material = material;
        this.data = (byte) data;
    }

    public Material getMaterial() {
        return material;
    }

    public byte getData() {
        return data;
    }
}
