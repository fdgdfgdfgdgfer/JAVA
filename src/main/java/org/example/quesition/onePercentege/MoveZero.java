package org.example.quesition.onePercentege;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/4/29 10:23
 * @PackageName:org.example.quesition.onePercentege
 * @ClassName: MoveZero
 */
public class MoveZero {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZero().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num+",");
        }
    }

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}




class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;
        for (int right = 0; right < len; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }
        while (left < len) {
            nums[left++] = 0;
        }
    }
}