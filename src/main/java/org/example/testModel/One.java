package org.example.testModel;

import java.util.*;

/**
 * @Author jfz
 * @Date 2024/3/25 8:48
 * @PackageName:org.example.testModel
 * @ClassName: One
 */
public class One {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1); // 初始化前缀和为0，出现次数为1

        for (int num : nums) {
            sum += num;
            if (sumFreq.containsKey(sum - k)) {
                count += sumFreq.get(sum - k);
            }
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        One solution = new One();
        int[] nums = {1, 2, 7};
        int k = 9;
        int result = solution.subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);
    }

}
