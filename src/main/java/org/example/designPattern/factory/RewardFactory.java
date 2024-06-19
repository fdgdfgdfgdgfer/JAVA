package org.example.designPattern.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 15:11
 * @PackageName:org.example.designPattern.factory
 * @ClassName: RewardFactory
 */
@Data
@NoArgsConstructor
public class RewardFactory {
    public RewardInterFace getReward(Integer type) {
        switch (type) {
            case 1:
                return new Thing();
            case 2:
                return new Vouchar();
            case 3:
                return new Member();
            default:
                break;
        }
        return null;
    }
}
