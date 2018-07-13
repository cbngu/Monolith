package gg.warcraft.monolith.app.core;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import gg.warcraft.monolith.api.config.BlockLocationConfiguration;
import gg.warcraft.monolith.api.config.BoundingBlockBoxConfiguration;
import gg.warcraft.monolith.api.config.LocationConfiguration;
import gg.warcraft.monolith.api.config.OrientedLocationConfiguration;
import gg.warcraft.monolith.api.config.Vector3iConfiguration;
import gg.warcraft.monolith.app.config.SimpleBlockLocationConfiguration;
import gg.warcraft.monolith.app.config.SimpleBoundingBlockBoxConfiguration;
import gg.warcraft.monolith.app.config.SimpleLocationConfiguration;
import gg.warcraft.monolith.app.config.SimpleOrientedLocationConfiguration;
import gg.warcraft.monolith.app.config.SimpleVector3iConfiguration;

public class MonolithMapperModule extends SimpleModule {

    public MonolithMapperModule() {
        super("MonolithMapperModule", Version.unknownVersion());
        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
        resolver.addMapping(BlockLocationConfiguration.class, SimpleBlockLocationConfiguration.class);
        resolver.addMapping(BoundingBlockBoxConfiguration.class, SimpleBoundingBlockBoxConfiguration.class);
        resolver.addMapping(LocationConfiguration.class, SimpleLocationConfiguration.class);
        resolver.addMapping(OrientedLocationConfiguration.class, SimpleOrientedLocationConfiguration.class);
        resolver.addMapping(Vector3iConfiguration.class, SimpleVector3iConfiguration.class);
        setAbstractTypes(resolver);
    }
}
