package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author jfz
 * @Date 2024/3/8 13:38
 * @PackageName:org.example.quesition
 * @ClassName: PivotIndex
 */
@Data
@NoArgsConstructor
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        // [1, 7, 3, 6, 5, 6]  3
        // 1 2 3 -> -1
        int leftSum = 0;
        int rightSum = IntStream.rangeClosed(0, nums.length - 1).map(g -> nums[g]).sum();
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            if (rightSum > leftSum) {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,7,3,6,5,6};
        int i = new PivotIndex().pivotIndex(a);
        System.out.println(i
        );
    }
}
