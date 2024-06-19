package org.example.designPattern.piping.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 14:48
 * @PackageName:org.example.designPattern.piping.order
 * @ClassName: OrderProcess
 */
public class OrderProcess extends ProcessModel {
    @Override
    public void action() {
        System.out.println("创建订单");
    }
}
