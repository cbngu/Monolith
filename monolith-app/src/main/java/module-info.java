module gg.warcraft.monolith.app {
    requires transitive gg.warcraft.monolith.api;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.google.common;
    requires github.api;
    requires jedis;

    exports gg.warcraft.monolith.app to gg.warcraft.monolith.spigot;

    // command module
    exports gg.warcraft.monolith.app.command to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.command.service to gg.warcraft.monolith.spigot, junit;

    opens gg.warcraft.monolith.app.command to org.mockito;
    opens gg.warcraft.monolith.app.command.service to org.mockito;

    // effect module
    exports gg.warcraft.monolith.app.effect to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.effect.particle to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.effect.renderer to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.effect.vectors to gg.warcraft.monolith.spigot, junit;

    opens gg.warcraft.monolith.app.effect to org.mockito;
    opens gg.warcraft.monolith.app.effect.particle to org.mockito;
    opens gg.warcraft.monolith.app.effect.renderer to org.mockito;
    opens gg.warcraft.monolith.app.effect.vectors to org.mockito;

    // entity module
    exports gg.warcraft.monolith.app.entity to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.entity.event to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.entity.service to gg.warcraft.monolith.spigot, junit;

    exports gg.warcraft.monolith.app.entity.attribute to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.entity.attribute.service to gg.warcraft.monolith.spigot, junit;

    exports gg.warcraft.monolith.app.entity.player to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.entity.player.event to gg.warcraft.monolith.spigot, junit;

    exports gg.warcraft.monolith.app.entity.status to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.entity.status.service to gg.warcraft.monolith.spigot, junit;

    // utility module
    exports gg.warcraft.monolith.app.util to gg.warcraft.monolith.spigot, junit;

    opens gg.warcraft.monolith.app.util to org.mockito;

    // world module
    exports gg.warcraft.monolith.app.world to gg.warcraft.monolith.spigot, junit;
    exports gg.warcraft.monolith.app.world.block to gg.warcraft.monolith.spigot, junit;

    opens gg.warcraft.monolith.app.world.block to org.mockito;
}
