package org.example.designPattern.bridging.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/26 8:53
 * @PackageName:org.example.designPattern.bridging.model
 * @ClassName: PayWay
 */

public abstract class PayWay {
    public PayModel payModel;

    public PayWay(PayModel payModel) {
        this.payModel = payModel;
    }

    public abstract void pay(int num);
}
