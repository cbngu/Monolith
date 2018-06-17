package gg.warcraft.monolith.api.world.event;

public interface BlockBreakEvent extends CancellableBlockEvent {

    boolean shouldDropItems();

    void setDropItems(boolean dropItems);
}
