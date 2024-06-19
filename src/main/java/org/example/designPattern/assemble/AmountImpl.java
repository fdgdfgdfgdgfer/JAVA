package org.example.designPattern.assemble;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.assemble.productdeml.Order;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/2/26 11:52
 * @PackageName:org.example.designPattern.assemble
 * @ClassName: AmountImpl
 */
public class AmountImpl implements Amount {
    @Override
    public BigDecimal getAmount(Order order) {
        return order.getTotalPrice();
    }
}
