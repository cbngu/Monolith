module gg.warcraft.monolith.api {
    requires transitive com.google.guice;
    requires transitive com.google.guice.extensions.assistedinject;
    requires transitive org.joml;

    // command module
    exports gg.warcraft.monolith.api.command;
    exports gg.warcraft.monolith.api.command.event;
    exports gg.warcraft.monolith.api.command.service;

    // configuration module
    exports gg.warcraft.monolith.api.config;

    // core module
    exports gg.warcraft.monolith.api.core;
    exports gg.warcraft.monolith.api.core.event;

    // effect module
    exports gg.warcraft.monolith.api.effect;

    // entity module
    exports gg.warcraft.monolith.api.entity;
    exports gg.warcraft.monolith.api.entity.event;
    exports gg.warcraft.monolith.api.entity.service;

    exports gg.warcraft.monolith.api.entity.player;
    exports gg.warcraft.monolith.api.entity.player.event;
    exports gg.warcraft.monolith.api.entity.player.service;

    exports gg.warcraft.monolith.api.entity.attribute;
    exports gg.warcraft.monolith.api.entity.attribute.service;

    exports gg.warcraft.monolith.api.entity.status;
    exports gg.warcraft.monolith.api.entity.status.service;

    // utility module
    exports gg.warcraft.monolith.api.util;

    // world module
    exports gg.warcraft.monolith.api.world;
    exports gg.warcraft.monolith.api.world.event;
    exports gg.warcraft.monolith.api.world.service;

    exports gg.warcraft.monolith.api.world.block;
}
