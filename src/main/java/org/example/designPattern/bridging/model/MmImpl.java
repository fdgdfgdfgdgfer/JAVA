package org.example.designPattern.bridging.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/26 9:00
 * @PackageName:org.example.designPattern.bridging.model
 * @ClassName: MmImpl
 */
public class MmImpl implements PayModel {
    @Override
    public int secutity() {
        System.out.println("密码支付");
        return 0;
    }
}
