package org.example.designPattern.builderModel.floor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.builderModel.Matter;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/1/26 14:37
 * @PackageName:org.example.designPattern.builderModel.material
 * @ClassName: Floor
 */
@Data
@NoArgsConstructor
public class ShiMuFloor  implements Matter {
    @Override
    public String stuff() {
        return "地板";
    }

    @Override
    public String brand() {
        return "实木地板";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("120");
    }

    @Override
    public String desc() {
        return "实木地板原始的气息，厚重的质感，待会回到大自然";
    }
}
