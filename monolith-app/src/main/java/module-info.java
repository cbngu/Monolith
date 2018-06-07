module gg.warcraft.monolith.app {
    requires transitive gg.warcraft.monolith.api;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.google.common;
    requires github.api;
    requires jedis;

    exports gg.warcraft.monolith.app.command to junit;
    exports gg.warcraft.monolith.app.command.service to junit;
    exports gg.warcraft.monolith.app.effect to junit;
    exports gg.warcraft.monolith.app.effect.particle to junit;
    exports gg.warcraft.monolith.app.effect.renderer to junit;
    exports gg.warcraft.monolith.app.effect.vectors to junit;
    exports gg.warcraft.monolith.app.util to junit;
    exports gg.warcraft.monolith.app.world.block to junit;

    opens gg.warcraft.monolith.app.command to org.mockito;
    opens gg.warcraft.monolith.app.command.service to org.mockito;
    opens gg.warcraft.monolith.app.effect to org.mockito;
    opens gg.warcraft.monolith.app.effect.particle to org.mockito;
    opens gg.warcraft.monolith.app.effect.renderer to org.mockito;
    opens gg.warcraft.monolith.app.effect.vectors to org.mockito;
    opens gg.warcraft.monolith.app.util to org.mockito;
    opens gg.warcraft.monolith.app.world.block to org.mockito;
}
