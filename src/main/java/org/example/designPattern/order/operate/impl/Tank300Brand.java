package org.example.designPattern.order.operate.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.order.operate.CarRun;

/**
 * @Author jfz
 * @Date 2024/3/6 13:39
 * @PackageName:org.example.designPattern.order.operate.impl
 * @ClassName: Tenk300
 */
public class Tank300Brand implements CarRun {

    @Override
    public void run() {
        System.out.println("Tank300 to across country");
    }
}
