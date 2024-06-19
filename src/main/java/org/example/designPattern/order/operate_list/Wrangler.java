package org.example.designPattern.order.operate_list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.order.operate.CarRun;

/**
 * @Author jfz
 * @Date 2024/3/6 13:43
 * @PackageName:org.example.designPattern.order.operate_list
 * @ClassName: Wrangler
 */
public class Wrangler implements AcrossCountryType {
    private CarRun carRun;

    public Wrangler(CarRun carRun) {
        this.carRun = carRun;
    }

    @Override
    public void type() {
        carRun.run();
    }
}
