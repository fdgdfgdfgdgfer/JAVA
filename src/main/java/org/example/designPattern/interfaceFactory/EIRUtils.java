package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author jfz
 * @Date 2024/1/25 16:12
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: EIRUtils
 */
@Data
@NoArgsConstructor
public class EIRUtils {
    public final static ConcurrentHashMap<String, String> EIRCache = new ConcurrentHashMap<>();

    public static void setEIR(String key, String value) {
        EIRCache.put(key, value);
    }

    public static void delEIR(String key) {
        EIRCache.remove(key);
    }

    public static void changeEIR(String key, String value) {
        EIRCache.put(key, value);
    }

    public static String gainEIR(String key) {
        return EIRCache.get(key);
    }
}
