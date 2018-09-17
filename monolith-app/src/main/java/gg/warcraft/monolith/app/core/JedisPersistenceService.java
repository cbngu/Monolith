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
import java.util.function.Consumer;
import java.util.function.Function;

@Singleton
public class JedisPersistenceService implements PersistenceService {
    private final JedisPool pool;

    @Inject
    public JedisPersistenceService(JedisPool pool) {
        this.pool = pool;
    }

    private void retryOnce(Consumer<Jedis> action) {
        try (Jedis jedis = pool.getResource()) {
            action.accept(jedis);
        } catch (Exception ex) {
            try (Jedis retryJedis = pool.getResource()) {
                action.accept(retryJedis);
            }
        }
    }

    private <T> T retryOnceWithResult(Function<Jedis, T> action) {
        try (Jedis jedis = pool.getResource()) {
            return action.apply(jedis);
        } catch (Exception ex) {
            try (Jedis retryJedis = pool.getResource()) {
                return action.apply(retryJedis);
            }
        }
    }

    @Override
    public String get(String key) {
        return retryOnceWithResult(jedis -> jedis.get(key));
    }

    @Override
    public void set(String key, String value) {
        retryOnce(jedis -> jedis.set(key, value));
    }

    @Override
    public List<String> getList(String key) {
        return retryOnceWithResult(jedis -> jedis.lrange(key, -1, Integer.MAX_VALUE));
    }

    @Override
    public void setList(String key, List<String> values) {
        retryOnce(jedis -> jedis.del(key));
        if (!values.isEmpty()) {
            retryOnce(jedis -> jedis.lpush(key, values.toArray(new String[0])));
        }
    }

    @Override
    public void pushList(String key, String value) {
        retryOnce(jedis -> jedis.lpush(key, value));
    }

    @Override
    public Map<String, String> getMap(String key) {
        return retryOnceWithResult(jedis -> jedis.hgetAll(key));
    }

    @Override
    public void setMap(String key, Map<String, String> values) {
        retryOnce(jedis -> values.forEach((field, value) -> jedis.hset(key, field, value)));
    }

    @Override
    public Set<String> getSet(String key) {
        return retryOnceWithResult(jedis -> jedis.smembers(key));
    }

    @Override
    public void addSet(String key, List<String> values) {
        if (!values.isEmpty()) {
            retryOnce(jedis -> jedis.sadd(key, values.toArray(new String[0])));
        }
    }

    @Override
    public void removeSet(String key, List<String> values) {
        if (!values.isEmpty()) {
            retryOnce(jedis -> jedis.srem(key, values.toArray(new String[0])));
        }
    }

    @Override
    public void delete(String key) {
        retryOnce(jedis -> jedis.del(key));
    }

    @Override
    public List<String> getAllKeys(String keyPrefix) {
        try (Jedis jedis = pool.getResource()) {
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
}
