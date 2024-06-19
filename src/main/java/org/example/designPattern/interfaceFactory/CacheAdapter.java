package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 15:54
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: CacheAdapter
 */
public interface CacheAdapter {
    void add(String key,String value);

    void del(String key);

    void change(String key,String value);

    String get(String key);
}
