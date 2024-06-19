package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 17:02
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: FactoryCache
 */
@Data
@NoArgsConstructor
@Builder
public class FactoryCache {
    public static CacheAdapter getCache(Integer type) {
        switch (type) {
            case 1:
                return new RedisLocal();
            case 2:
                return new EIR();
            case 3:
                return new IRR();
        }
        return null;
    }
}
