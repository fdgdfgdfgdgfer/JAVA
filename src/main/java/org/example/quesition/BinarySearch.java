package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/6 10:37
 * @PackageName:org.example.quesition
 * @ClassName: BinarySearch
 */
@Data
@NoArgsConstructor
public class BinarySearch {
    public int search(int[] nums, int target) {

        int top = 0, tail = nums.length - 1;
        while (top <= tail) {
            int mod = (top + tail) / 2;
            if (target == nums[mod]) {
                return nums[mod];
            }
            if (target > nums[mod]) {
                top = mod + 1;
            }
            if (target < nums[mod]) {
                tail = mod - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6, 9, 10};
        int search = new BinarySearch().search(a, 4);
        System.out.println(search);
    }
}
