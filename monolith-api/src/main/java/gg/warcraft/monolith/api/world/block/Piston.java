package gg.warcraft.monolith.api.world.block;

public interface Piston extends DirectionalBlock {

    boolean isPowered();

    boolean isSticky();

    Piston withPowered(boolean powered);

    Piston withSticky(boolean sticky);
}
