package org.example.designPattern.single;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 10:42
 * @PackageName:org.example.designPattern.single
 * @ClassName: LazySingleSafe
 */
@Data
public class LazySingleSafe {
    private static LazySingleSafe lazySingle;

    private LazySingleSafe() {
    }

    private synchronized LazySingleSafe get() {
        if (lazySingle == null) {
            lazySingle = new LazySingleSafe();
        }
        return lazySingle;
    }
}
