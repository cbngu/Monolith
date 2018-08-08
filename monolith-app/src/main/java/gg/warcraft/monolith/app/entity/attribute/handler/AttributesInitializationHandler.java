package gg.warcraft.monolith.app.entity.attribute.handler;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import gg.warcraft.monolith.api.entity.attribute.Attributes;
import gg.warcraft.monolith.api.entity.attribute.GenericAttribute;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeCommandService;
import gg.warcraft.monolith.api.entity.attribute.service.AttributeRepository;
import gg.warcraft.monolith.api.entity.player.event.PlayerConnectEvent;
import gg.warcraft.monolith.app.entity.attribute.LazyAttributes;

import java.util.HashMap;
import java.util.UUID;

public class AttributesInitializationHandler {
    private final AttributeCommandService attributeCommandService;
    private final AttributeRepository attributeRepository;
    private final float baseHealth;

    @Inject
    public AttributesInitializationHandler(AttributeCommandService attributeCommandService,
                                           AttributeRepository attributeRepository,
                                           @Named("BaseHealth") Float baseHealth) {
        this.attributeCommandService = attributeCommandService;
        this.attributeRepository = attributeRepository;
        this.baseHealth = baseHealth;
    }

    @Subscribe
    public void onPlayerConnectEvent(PlayerConnectEvent event) {
        UUID playerId = event.getPlayerId();
        Attributes attributes = attributeRepository.getAttributes(playerId);
        if (attributes == null) {
            Attributes newAttributes = new LazyAttributes(attributeCommandService, playerId, new HashMap<>());
            attributeRepository.save(newAttributes);

            attributeCommandService.addAttributeModifier(playerId, GenericAttribute.MAX_HEALTH, baseHealth);
        }

        // TODO add modifiers for serverside generic attributes
    }

    // TODO do we want to delete attributes on player disconnect?
}
