package org.example.designPattern.order.order;

import static org.junit.Assert.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.order.operate.impl.BigBenZBrand;
import org.example.designPattern.order.operate.impl.Tank300Brand;
import org.example.designPattern.order.operate.impl.WranglerBrand;
import org.example.designPattern.order.operate_list.BenZ;
import org.example.designPattern.order.operate_list.Tank300;
import org.example.designPattern.order.operate_list.Wrangler;
import org.junit.Test;

/**
 * @Author jfz
 * @Date 2024/3/6 13:48
 * @PackageName:org.example.designPattern.order.order
 * @ClassName: OrderTest
 */

public class OrderTest {

    @Test
    public void test() {
        //车系菜单
        BenZ benZ = new BenZ(new BigBenZBrand());
        Tank300 tank300 = new Tank300(new Tank300Brand());
        Wrangler wrangler = new Wrangler(new WranglerBrand());
        //选择
        Order.order(benZ);
        Order.order(wrangler);

        Order.goOn();
    }
}