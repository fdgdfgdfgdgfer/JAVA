package org.example.designPattern.interfaceFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 16:24
 * @PackageName:org.example.designPattern.interfaceFactory
 * @ClassName: IRR
 */
@Data
@NoArgsConstructor
public class IRR implements CacheAdapter {
    @Override
    public void add(String key, String value) {
        IRRUtils.addIRR(key, value);
    }

    @Override
    public void del(String key) {
        IRRUtils.delIRR(key);
    }

    @Override
    public void change(String key, String value) {
        IRRUtils.changeIRR(key, value);
    }

    @Override
    public String get(String key) {
        return "IRR" + IRRUtils.getIRR(key);
    }
}
