package org.example.designPattern.assemble;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/26 11:02
 * @PackageName:org.example.designPattern.assemble
 * @ClassName: DLDecorate
 */
public class DLDecorate extends BaseDecorator {
    public DLDecorate(Decorate decorate) {
        super(decorate);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("地暖");
    }
}
