package org.example.designPattern.assemble;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.assemble.productdeml.Order;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/2/26 11:50
 * @PackageName:org.example.designPattern.assemble
 * @ClassName: Acoumt
 */
public interface Amount {
    BigDecimal getAmount(Order order);
}
