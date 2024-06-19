package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 16:23
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: EIR
 */
@Data
@NoArgsConstructor
public class EIR implements CacheAdapter {
    @Override
    public void add(String key, String value) {
        EIRUtils.setEIR(key, value);
    }

    @Override
    public void del(String key) {
        EIRUtils.delEIR(key);
    }

    @Override
    public void change(String key, String value) {
        EIRUtils.changeEIR(key, value);
    }

    @Override
    public String get(String key) {
        return  "EIR" +EIRUtils.gainEIR(key);
    }
}
