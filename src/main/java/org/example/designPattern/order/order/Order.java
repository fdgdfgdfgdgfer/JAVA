package org.example.designPattern.order.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.order.operate_list.AcrossCountryType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jfz
 * @Date 2024/3/6 13:45
 * @PackageName:org.example.designPattern.order.order
 * @ClassName: Order
 */
@Data
@NoArgsConstructor
public class Order {

    private static List<AcrossCountryType> list = new ArrayList<>();


    public static void order(AcrossCountryType acrossCountryType) {
        list.add(acrossCountryType);
    }

    public static void goOn() {
        for (AcrossCountryType acrossCountryType : list) {
            acrossCountryType.type();
        }
    }
}
