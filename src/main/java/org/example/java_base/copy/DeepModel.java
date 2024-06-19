package org.example.java_base.copy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/14 14:57
 * @PackageName:org.example.java_base.copy
 * @ClassName: DeepModel
 */
@Data
public class DeepModel implements Cloneable {
    private String name;
    private Prent prent;

    public DeepModel(String name, Prent prent) {
        this.name = name;
        this.prent = prent;
    }

    @Override
    public DeepModel clone() throws CloneNotSupportedException {
        DeepModel clone = (DeepModel) super.clone();
        clone.prent = prent.clone();
        return clone;
    }

}
