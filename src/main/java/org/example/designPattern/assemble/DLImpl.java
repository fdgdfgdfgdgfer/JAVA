package org.example.designPattern.assemble;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/26 11:04
 * @PackageName:org.example.designPattern.assemble
 * @ClassName: DLImpl
 */
public class DLImpl implements Decorate {
    @Override
    public void decorate() {
        System.out.println("地暖");
    }
}
