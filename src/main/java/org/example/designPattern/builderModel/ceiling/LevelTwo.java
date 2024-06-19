package org.example.designPattern.builderModel.ceiling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.builderModel.Matter;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/1/26 14:53
 * @PackageName:org.example.designPattern.builderModel.ceiling
 * @ClassName: LevelTwo
 */
@Data
@NoArgsConstructor
public class LevelTwo implements Matter {
    @Override
    public String stuff() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "二级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("123");
    }

    @Override
    public String desc() {
        return "轻视，简约";
    }
}
