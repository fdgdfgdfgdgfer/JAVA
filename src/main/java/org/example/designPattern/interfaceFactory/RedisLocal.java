package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 15:55
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: RedisLocal
 */
@Data
@NoArgsConstructor
public class RedisLocal implements CacheAdapter {

    @Override
    public void add(String key, String value) {
        RedisUtils.add(key, value);
    }

    @Override
    public void del(String key) {
        RedisUtils.del(key);
    }

    @Override
    public void change(String key, String value) {
        RedisUtils.change(key, value);
    }

    @Override
    public String get(String key) {
        return "redis" + RedisUtils.get(key);
    }
}
