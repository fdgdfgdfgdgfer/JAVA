package org.example.designPattern.assemble;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/26 10:58
 * @PackageName:org.example.designPattern.assemble
 * @ClassName: WindowDecorate
 */
public class WindowDecorate extends BaseDecorator {

    public WindowDecorate(Decorate decorate) {
        super(decorate);
    }
}
