module gg.warcraft.monolith.api {
    requires transitive com.google.guice;
    requires transitive com.google.guice.extensions.assistedinject;
    requires transitive org.joml;

    exports gg.warcraft.monolith.api.util;

    // world module
    exports gg.warcraft.monolith.api.world;
    exports gg.warcraft.monolith.api.world.event;
    exports gg.warcraft.monolith.api.world.service;

    exports gg.warcraft.monolith.api.world.block;
}
