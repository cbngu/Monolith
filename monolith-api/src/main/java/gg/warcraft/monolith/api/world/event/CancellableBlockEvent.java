package gg.warcraft.monolith.api.world.event;

public interface CancellableBlockEvent extends BlockEvent {

    boolean isCancelled();

    void setCancelled(boolean cancellable);
}
