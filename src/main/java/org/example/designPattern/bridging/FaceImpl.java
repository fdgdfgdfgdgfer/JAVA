package org.example.designPattern.bridging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.bridging.model.PayModel;

/**
 * @Author jfz
 * @Date 2024/2/26 8:59
 * @PackageName:org.example.designPattern.bridging
 * @ClassName: FaceImpl
 */
public class FaceImpl implements PayModel {
    @Override
    public int secutity() {
        System.out.println("人脸支付");
        return 0;
    }
}
