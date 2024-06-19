package org.example.designPattern.bridging.pay;
import org.example.designPattern.bridging.model.PayModel;
import org.example.designPattern.bridging.model.PayWay;
/**
 * @Author jfz
 * @Date 2024/2/26 9:06
 * @PackageName:org.example.designPattern.bridging.pay
 * @ClassName: ZfbPay
 */
public class ZfbPay extends PayWay {

    public ZfbPay(PayModel payModel) {
        super(payModel);
    }

    @Override
    public void pay(int num) {
        int secutity = payModel.secutity();

        System.out.println("支付完成");
    }
}
