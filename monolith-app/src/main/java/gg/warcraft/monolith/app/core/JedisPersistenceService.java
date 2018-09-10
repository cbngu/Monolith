package gg.warcraft.monolith.app.core;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import gg.warcraft.monolith.api.core.PersistenceService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Singleton
public class JedisPersistenceService implements PersistenceService {
    private final JedisPool pool;

    private Jedis jedis;

    @Inject
    public JedisPersistenceService(JedisPool pool) {
        this.pool = pool;
        this.jedis = pool.getResource();
    }

    @Override
    public String get(String key) {
        try {
            return jedis.get(key);
        } catch (Exception ex) {
            jedis.close();
            jedis = pool.getResource();
        }
        return jedis.get(key);
    }

    @Override
    public void set(String key, String value) {
        try {
            jedis.set(key, value);
        } catch (Exception ex) {
            // FIXME look into caching failed attempts if new resource doesn't work
            jedis.close();
            jedis = pool.getResource();
        }
        jedis.set(key, value);
    }

    @Override
    public List<String> getList(String key) {
        return jedis.lrange(key, -1, Integer.MAX_VALUE);
    }

    @Override
    public void setList(String key, List<String> values) {
        jedis.del(key);
        if (!values.isEmpty()) {
            jedis.lpush(key, values.toArray(new String[0]));
        }
    }

    @Override
    public void pushList(String key, String value) {
        jedis.lpush(key, value);
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
    public Set<String> getSet(String key) {
        return jedis.smembers(key);
    }

    @Override
    public void addSet(String key, List<String> values) {
        if (!values.isEmpty()) {
            jedis.sadd(key, values.toArray(new String[0]));
        }
    }

    @Override
    public void removeSet(String key, List<String> values) {
        if (!values.isEmpty()) {
            jedis.srem(key, values.toArray(new String[0]));
        }
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
