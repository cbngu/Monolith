package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import gg.warcraft.monolith.api.config.BlockLocationConfiguration;
import gg.warcraft.monolith.api.config.BoundingBlockBoxConfiguration;
import gg.warcraft.monolith.api.config.LocationConfiguration;
import gg.warcraft.monolith.api.config.OrientedLocationConfiguration;
import gg.warcraft.monolith.api.config.PortalConfiguration;
import gg.warcraft.monolith.api.config.Vector3iConfiguration;

public class MonolithMapperModule extends SimpleModule {

    public MonolithMapperModule() {
        super("MonolithMapperModule", Version.unknownVersion());
        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
        resolver.addMapping(BlockLocationConfiguration.class, JacksonBlockLocationConfiguration.class);
        resolver.addMapping(BoundingBlockBoxConfiguration.class, JacksonBoundingBlockBoxConfiguration.class);
        resolver.addMapping(LocationConfiguration.class, JacksonLocationConfiguration.class);
        resolver.addMapping(OrientedLocationConfiguration.class, JacksonOrientedLocationConfiguration.class);
        resolver.addMapping(PortalConfiguration.class, JacksonPortalConfiguration.class);
        resolver.addMapping(Vector3iConfiguration.class, JacksonVector3iConfiguration.class);
        setAbstractTypes(resolver);
    }
}
