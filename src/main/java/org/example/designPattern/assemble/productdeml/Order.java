package org.example.designPattern.assemble.productdeml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author jfz
 * @Date 2024/2/26 11:40
 * @PackageName:org.example.designPattern.assemble.productdeml
 * @ClassName: Order
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private String id;
    private BigDecimal totalPrice;
    private List<Promotion> promotionType;
}
