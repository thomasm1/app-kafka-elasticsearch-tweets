package app.mapl.util.config;

import com.google.common.cache.CacheBuilder;
import jakarta.validation.constraints.NotNull;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static app.mapl.CliApplication.log;

public class CacheStore<K, V> {
    private Map<K, V> cache;
    private final long ttl;
    private final TimeUnit timeUnit;

    public CacheStore(long ttl, TimeUnit timeUnit) {
        cache = (Map<K, V>) CacheBuilder.newBuilder()
                .expireAfterWrite(ttl, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();

        this.ttl = ttl;
        this.timeUnit = timeUnit;
    }

    public V get(@NotNull K key) {
        log.info("retrieving record from cache for user: key: " + key.toString());
        return cache.get(key);
    }

    public void put(@NotNull K key, @NotNull V value) {
        log.info("storing record in cache for user: key: " + key.toString() + " value: " + value.toString());
        cache.put(key, value);
    }

    public V evict(@NotNull K key) {
        log.info("Removing login-attempt cache for user: " + key.toString());
        return cache.get(key);
    }
}
