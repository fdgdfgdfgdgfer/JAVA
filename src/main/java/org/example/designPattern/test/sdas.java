package org.example.designPattern.test;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/26 16:44
 * @PackageName:org.example.designPattern.builderModel
 * @ClassName: sdas
 */
@Data
@NoArgsConstructor
public class sdas implements Cloneable {
    public AS as = new AS();
    @Override
    public Object clone() throws CloneNotSupportedException {
        sdas a = (sdas) super.clone();
        a.as = (AS)this.as.clone();
        return a;
    }

}
