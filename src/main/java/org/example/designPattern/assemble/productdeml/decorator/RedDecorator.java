package org.example.designPattern.assemble.productdeml.decorator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.assemble.Amount;
import org.example.designPattern.assemble.productdeml.Order;
import org.example.designPattern.assemble.productdeml.Promotion;

import java.math.BigDecimal;
import java.util.stream.Collectors;

/**
 * @Author jfz
 * @Date 2024/2/26 12:03
 * @PackageName:org.example.designPattern.assemble.productdeml.decorator
 * @ClassName: RedDecorator
 */
public class RedDecorator extends BaseDecoratorByPrice {
    public RedDecorator(Amount amount) {
        super(amount);
    }

    @Override
    public BigDecimal getAmount(Order order) {
        BigDecimal amount1 = super.getAmount(order);
        Promotion red = order.getPromotionType().stream().filter(or -> or.getPromotion().equals("RED")).collect(Collectors.toList()).get(0);
        order.setTotalPrice(getRedTail(amount1, red.getAmount()));
        return order.getTotalPrice();
    }

    public BigDecimal getRedTail(BigDecimal total, BigDecimal red) {
        return total.subtract(red);
    }
}
