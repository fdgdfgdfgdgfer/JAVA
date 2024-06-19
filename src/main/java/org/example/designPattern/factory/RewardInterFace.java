package org.example.designPattern.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/1/25 15:05
 * @PackageName:org.example.designPattern.factory
 * @ClassName: RewardInterFace
 */
public interface RewardInterFace {
    void rewardClass(String uid);
}
