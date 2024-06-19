package org.example.designPattern.assemble;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/26 10:55
 * @PackageName:org.example.designPattern.assemble
 * @ClassName: BaseDecorate
 */
public abstract class BaseDecorator implements Decorate {
    private Decorate decorate;

    public BaseDecorator(Decorate decorate) {
        this.decorate = decorate;
    }

    @Override
    public void decorate() {
        decorate.decorate();
    }
}
