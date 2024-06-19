package org.example.designPattern.single;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 10:31
 * @PackageName:org.example.designPattern.single
 * @ClassName: LazySingle
 */

@Data
public class LazySingle {
    private static LazySingle lazySingle;

    private LazySingle() {

    }
    public static LazySingle getInstance() {
        if (lazySingle == null) {
            lazySingle = new LazySingle();
        }
        return lazySingle;
    }
}
