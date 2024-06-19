package org.example.java_base.copy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author jfz
 * @Date 2024/3/14 14:59
 * @PackageName:org.example.java_base.copy
 * @ClassName: Prent
 */
@Data
@NoArgsConstructor
public class Prent implements Cloneable, Serializable {
    @Override
    public Prent clone() throws CloneNotSupportedException {
        return (Prent) super.clone();
    }
}
