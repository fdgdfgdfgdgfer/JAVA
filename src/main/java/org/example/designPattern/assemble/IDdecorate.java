package org.example.designPattern.assemble;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/26 10:53
 * @PackageName:org.example.designPattern.assemble
 * @ClassName: IDdecorate
 */
@Data
@NoArgsConstructor
public class IDdecorate implements Decorate {
    @Override
    public void decorate() {
        System.out.println("粉刷，吊顶...");
    }
}
