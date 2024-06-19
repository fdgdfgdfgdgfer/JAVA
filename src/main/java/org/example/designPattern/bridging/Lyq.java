package org.example.designPattern.bridging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 17:20
 * @PackageName:org.example.designPattern.bridging
 * @ClassName: Lyq
 */
public class Lyq extends CommonShow {
    public Lyq(CommonAc commonAc) {
        super(commonAc);
    }

    @Override
    String show() {
        return commonAc.show();
    }
}
