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
 * @ClassName: LevelOne
 */
@Data
@NoArgsConstructor
public class LevelOne implements Matter {
    @Override
    public String stuff() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "一级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("452");
    }

    @Override
    public String desc() {
        return "华丽，庄严";
    }
}
