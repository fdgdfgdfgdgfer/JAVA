package org.example.designPattern.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 15:10
 * @PackageName:org.example.designPattern.factory
 * @ClassName: Member
 */

@Data
@NoArgsConstructor
public class Member implements RewardInterFace {
    @Override
    public void rewardClass(String uid) {
        System.out.println(RewardService.getMember(uid));
    }
}
