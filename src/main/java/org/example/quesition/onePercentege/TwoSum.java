package org.example.quesition.onePercentege;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.quesition.DoubleSum;

import java.util.HashMap;

/**
 * @Author jfz
 * @Date 2024/4/29 9:31
 * @PackageName:org.example.quesition.onePercentege
 * @ClassName: TwoSum
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] nums = new TwoSum().twoSum(a, 5);
        for (int s :nums) {
            System.out.println(s);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return nums;
    }
}
