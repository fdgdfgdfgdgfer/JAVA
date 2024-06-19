package org.example.designPattern.single;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 10:45
 * @PackageName:org.example.designPattern.single
 * @ClassName: HungrySingle
 */
@Data
public class HungrySingle {
    private static HungrySingle hungrySingle = new HungrySingle();

    private HungrySingle() {
    }

    private static HungrySingle getIntence() {
        return hungrySingle;
    }

}
