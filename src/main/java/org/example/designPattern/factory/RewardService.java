package org.example.designPattern.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 14:59
 * @PackageName:org.example.designPattern.factory
 * @ClassName: GoodsService
 */
@Data
@NoArgsConstructor
public class RewardService {
    //事物
    public static String getGoods(String uid) {
        return uid + "获得商品";
    }

    //礼卷
    public static String getVoucher(String uid) {
        return uid + "直减50%大礼卷";
    }

    //会员
    public static String getMember(String uid) {
        return uid + "获得爱奇艺会员一年";
    }
}
