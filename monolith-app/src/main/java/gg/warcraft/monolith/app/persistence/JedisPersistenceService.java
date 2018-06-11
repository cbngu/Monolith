package gg.warcraft.monolith.app.persistence;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.persistence.PersistenceService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JedisPersistenceService implements PersistenceService {
    private final Jedis jedis;

    @Inject
    public JedisPersistenceService(JedisPool pool) {
        this.jedis = pool.getResource();
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }

    @Override
    public void set(String key, String value) {
        jedis.set(key, value);
    }

    @Override
    public Map<String, String> getMap(String key) {
        return jedis.hgetAll(key);
    }

    @Override
    public void setMap(String key, Map<String, String> values) {
        values.forEach((field, value) -> jedis.hset(key, field, value));
    }

    @Override
    public void delete(String key) {
        jedis.del(key);
    }

    @Override
    public List<String> getAllKeys(String keyPrefix) {
        List<String> keys = new ArrayList<>();

        ScanParams scanParams = new ScanParams().match(keyPrefix + "*");
        String cur = ScanParams.SCAN_POINTER_START;
        do {
            ScanResult<String> scanResult = jedis.scan(cur, scanParams);

            keys.addAll(scanResult.getResult());
            cur = scanResult.getStringCursor();
        } while (!cur.equals(ScanParams.SCAN_POINTER_START));
        return keys;
    }
}
