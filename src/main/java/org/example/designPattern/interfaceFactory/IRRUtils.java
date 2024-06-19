package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author jfz
 * @Date 2024/1/25 16:15
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: IRR
 */
@Data
@NoArgsConstructor
public class IRRUtils {
    public static final ConcurrentHashMap<String, String> IRR = new ConcurrentHashMap<>();

    public static void addIRR(String key, String value) {
        IRR.put(key, value);
    }

    public static void delIRR(String key) {
        IRR.remove(key);
    }

    public static void changeIRR(String key, String value) {
        IRR.put(key, value);
    }

    public static String getIRR(String key) {
        return IRR.get(key);
    }
}
