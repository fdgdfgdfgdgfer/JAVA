package org.example.quesition.onePercentege;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/4/30 9:37
 * @PackageName:org.example.quesition.onePercentege
 * @ClassName: ChildSum
 */
public class ChildSum {
    //：nums = [1,2,3], k = 3
    public static void main(String[] arg) {
        int[] a = {1,1,1};

        int nums = new ChildSum().subarraySum(a, 2);
        System.out.print(nums);
    }

    public int subarraySum(int[] nums, int k) {
        int i = 0;
        int cont = 0;
        for (int t = 0; t < nums.length; t++) {
            int j = i;
            while (j < nums.length -1) {
                j++;
                if (nums[i] + nums[j] == k) {
                    cont++;
                }
            }
        }
        return cont;
    }

}
