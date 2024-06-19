package org.example.designPattern.bridging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 17:19
 * @PackageName:org.example.designPattern.bridging
 * @ClassName: Mouth
 */
public class Mouth implements CommonAc{
    @Override
    public String show() {
        return "嘴";
    }
}
