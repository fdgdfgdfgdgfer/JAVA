package org.example.designPattern.builderModel.coating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.builderModel.Matter;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/1/26 14:50
 * @PackageName:org.example.designPattern.builderModel.coating
 * @ClassName: FLSCoating
 */
@Data
@NoArgsConstructor
public class FLSCoating implements Matter {
    @Override
    public String stuff() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "多乐士";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("630");
    }

    @Override
    public String desc() {
        return "多乐士漆料细腻光泽安全健康";
    }
}
