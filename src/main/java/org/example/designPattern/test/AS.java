package org.example.designPattern.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/26 17:07
 * @PackageName:org.example.designPattern.test
 * @ClassName: AS
 */
@Data
@NoArgsConstructor
public class AS implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        AS clone = (AS)super.clone();
        return clone;
    }
}
