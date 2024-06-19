package org.example.designPattern.order.operate_list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.order.operate.CarRun;

/**
 * @Author jfz
 * @Date 2024/3/6 13:42
 * @PackageName:org.example.designPattern.order.operate_list
 * @ClassName: BenZ
 */
public class BenZ implements AcrossCountryType {
    private CarRun carRun;

    public BenZ(CarRun carRun) {
        this.carRun = carRun;
    }

    @Override
    public void type() {
        carRun.run();
    }
}
