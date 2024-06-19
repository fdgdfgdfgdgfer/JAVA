package org.example.designPattern.factory;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 15:09
 * @PackageName:org.example.designPattern.factory
 * @ClassName: Vouchar
 */
@Data
@NoArgsConstructor
public class Vouchar implements RewardInterFace {
    @Override
    public void rewardClass(String uid) {
        System.out.println(RewardService.getVoucher(uid));
    }
}
