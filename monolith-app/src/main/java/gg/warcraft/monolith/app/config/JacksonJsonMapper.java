package gg.warcraft.monolith.app.config;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import gg.warcraft.monolith.api.config.JsonMapper;

import java.io.Reader;

public class JacksonJsonMapper implements JsonMapper {
    private final ObjectMapper mapper;

    public JacksonJsonMapper() {
        this.mapper = new ObjectMapper(new JsonFactory());
    }

    @Override
    public <T> T from(String json, Class<T> to) {
        try {
            return mapper.readValue(json, to);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to parse JSON '" + json + "'", ex.getCause());
        }
    }

    @Override
    public <T> T from(Reader json, Class<T> to) {
        try {
            return mapper.readValue(json, to);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to read JSON '" + json + "'", ex.getCause());
        }
    }

    @Override
    public String to(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to create JSON from '" + object + "'", ex.getCause());
        }
    }
}