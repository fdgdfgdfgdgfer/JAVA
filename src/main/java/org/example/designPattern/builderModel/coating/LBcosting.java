package org.example.designPattern.builderModel.coating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.builderModel.Matter;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/1/26 14:49
 * @PackageName:org.example.designPattern.builderModel.coating
 * @ClassName: LBcosting
 */
@Data
@NoArgsConstructor
public class LBcosting implements Matter {

    @Override
    public String stuff() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "立邦";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("125");
    }

    @Override
    public String desc() {
        return "立邦涂料，大自然的气息无甲醛草本";
    }
}
