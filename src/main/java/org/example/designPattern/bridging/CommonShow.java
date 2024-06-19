package org.example.designPattern.bridging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 17:17
 * @PackageName:org.example.designPattern.bridging
 * @ClassName: CommonShow
 */
public abstract class CommonShow {
    public CommonAc commonAc;

    public CommonShow(CommonAc commonAc) {
        this.commonAc = commonAc;
    }

    abstract String show();
}
