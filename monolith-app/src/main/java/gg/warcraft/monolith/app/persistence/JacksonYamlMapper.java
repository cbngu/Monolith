package gg.warcraft.monolith.app.persistence;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import gg.warcraft.monolith.api.persistence.YamlMapper;

import java.io.Reader;

public class JacksonYamlMapper implements YamlMapper {
    private final ObjectMapper mapper;

    public JacksonYamlMapper() {
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper = yamlMapper;
    }

    @Override
    public <T> T parse(String yaml, Class<T> to) {
        try {
            return mapper.readValue(yaml, to);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to parse YAML: " + ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public <T> T parse(Reader yaml, Class<T> to) {
        try {
            return mapper.readValue(yaml, to);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to read YAML: " + ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public String stringify(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to create YAML: " + ex.getMessage(), ex.getCause());
        }
    }
}
