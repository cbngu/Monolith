module gg.warcraft.monolith.app {
    requires transitive gg.warcraft.monolith.api;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.google.common;
    requires github.api;
    requires jedis;

    exports gg.warcraft.monolith.app;
}
