package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/2 9:16
 * @PackageName:org.example.quesition
 * @ClassName: TwoSum
 */
@Data
@NoArgsConstructor
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int num = numbers[i] + numbers[j];
            if (num > target) {
                j--;
            } else if (num < target) {
                i++;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        //numbers = [0,0,3,4], target = 9
        int[] s = {0, 0, 3, 4};
        int[] ints = new TwoSum().twoSum(s, 0);
        for (int a : ints) {
            System.out.println(a);
        }
    }
}
