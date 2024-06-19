package org.example.designPattern.single;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 10:47
 * @PackageName:org.example.designPattern.single
 * @ClassName: StaticInnerSingle
 */
@Data
public class StaticInnerSingle {
    private StaticInnerSingle() {

    }
    private static class Intence {
        private static final StaticInnerSingle staticInnerSingle = new StaticInnerSingle();
    }

    public static StaticInnerSingle getInstance() {
        return Intence.staticInnerSingle;
    }
}
