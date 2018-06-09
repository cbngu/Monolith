package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import gg.warcraft.monolith.api.config.YamlMapper;

import java.io.Reader;

public class JacksonYamlMapper implements YamlMapper {
    private final ObjectMapper mapper;

    public JacksonYamlMapper() {
        this.mapper = new ObjectMapper(new YAMLFactory());
    }

    @Override
    public <T> T parse(String yaml, Class<T> to) {
        try {
            return mapper.readValue(yaml, to);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to parse YAML '" + yaml + "'", ex.getCause());
        }
    }

    @Override
    public <T> T parse(Reader yaml, Class<T> to) {
        try {
            return mapper.readValue(yaml, to);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to read YAML '" + yaml + "'", ex.getCause());
        }
    }

    @Override
    public String stringify(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to create YAML from '" + object + "'", ex.getCause());
        }
    }
}
