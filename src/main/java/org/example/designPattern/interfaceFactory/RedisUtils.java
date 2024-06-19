package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author jfz
 * @Date 2024/1/25 15:56
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: RedisUtils
 */
@Data
@NoArgsConstructor
public class RedisUtils {
    public final static ConcurrentHashMap<String, String> redisCache = new ConcurrentHashMap<>();

    static void add(String key, String value) {
        redisCache.put(key, value);
    }

    static void del(String key) {
        redisCache.remove(key);
    }

    static void change(String key, String value) {
        redisCache.put(key, value);
    }

    static String get(String key) {
        return redisCache.get(key);
    }

}
