package org.example.designPattern.order.operate.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.order.operate.CarRun;

/**
 * @Author jfz
 * @Date 2024/3/6 13:38
 * @PackageName:org.example.designPattern.order.operate.impl
 * @ClassName: BigBenZ
 */
public class BigBenZBrand implements CarRun {
    @Override
    public void run() {
        System.out.println("Big BenZ to across country");
    }

}
