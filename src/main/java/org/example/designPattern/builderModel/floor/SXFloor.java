package org.example.designPattern.builderModel.floor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.builderModel.Matter;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/1/26 14:40
 * @PackageName:org.example.designPattern.builderModel.floor
 * @ClassName: SXFloor
 */
@Data
@NoArgsConstructor
public class SXFloor implements Matter {
    @Override
    public String stuff() {
        return "地板";
    }

    @Override
    public String brand() {
        return "圣象";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("523");
    }

    @Override
    public String desc() {
        return "圣像地板，如同大象的脚安全的同时带来舒适感";
    }
}
