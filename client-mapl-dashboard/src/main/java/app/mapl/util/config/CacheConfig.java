package app.mapl.util.config;

import jakarta.validation.constraints.NotNull;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static app.mapl.CliApplication.log;

@Configuration
public class CacheConfig {
    private CacheStore<Object, Object> cache;

    @Bean(name = { "userloginCache"})
    public CacheStore<String, Integer> userCache() {
        return new CacheStore<>(900, TimeUnit.SECONDS);
    }

    public Object get(@NotNull Object key) {
        return cache.get(key);
    }

    public void put(@NotNull Object key, @NotNull Object value) {
        log.info("storing record in cache for user: key: " + key + " value: " + value);
        cache.put(key, value);
    }

    public void evict(@NotNull Object key) {
        log.info("storing record in cache for user: key: " + key);
        cache.evict(key);
    ;
    }
}
