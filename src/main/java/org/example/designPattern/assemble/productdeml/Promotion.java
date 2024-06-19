package org.example.designPattern.assemble.productdeml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/2/26 11:45
 * @PackageName:org.example.designPattern.assemble.productdeml
 * @ClassName: Promotion
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion implements Cloneable {
    private String promotion;
    private BigDecimal amount;

    @Override
    public Promotion clone() {
        Promotion clone = null;
        try {
            clone = (Promotion) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }

}
