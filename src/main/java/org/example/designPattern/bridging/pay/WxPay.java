package org.example.designPattern.bridging.pay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.bridging.model.PayModel;
import org.example.designPattern.bridging.model.PayWay;

/**
 * @Author jfz
 * @Date 2024/2/26 9:01
 * @PackageName:org.example.designPattern.bridging.pay
 * @ClassName: WxPay
 */
public class WxPay extends PayWay {
    public WxPay(PayModel payModel) {
        super(payModel);
    }

    @Override
    public void pay(int num) {
        int secutity = payModel.secutity();
        System.out.println("支付完成");
    }
}
