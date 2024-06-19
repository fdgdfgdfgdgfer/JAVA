package org.example.designPattern.assemble.productdeml.decorator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.assemble.Amount;
import org.example.designPattern.assemble.AmountImpl;
import org.example.designPattern.assemble.productdeml.Order;

import java.math.BigDecimal;

/**
 * @Author jfz
 * @Date 2024/2/26 11:53
 * @PackageName:org.example.designPattern.assemble.productdeml.decorator
 * @ClassName: BaseDecaratorByPrice
 */

public abstract class BaseDecoratorByPrice implements Amount {
    public Amount amount;

    public BaseDecoratorByPrice(Amount amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal getAmount(Order order) {
        return order.getTotalPrice();
    }
}
