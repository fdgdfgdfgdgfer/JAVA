package org.example.designPattern.bridging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.bridging.model.PayModel;

/**
 * @Author jfz
 * @Date 2024/2/26 8:58
 * @PackageName:org.example.designPattern.bridging
 * @ClassName: SzImpl
 */
public class SzImpl implements PayModel {
    @Override
    public int secutity() {
        System.out.println("指纹支付");
        return 0;
    }
}
