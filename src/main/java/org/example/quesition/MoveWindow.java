package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author jfz
 * @Date 2024/2/5 8:58
 * @PackageName:org.example.quesition
 * @ClassName: MoveWindow
 */
@Data
@NoArgsConstructor
public class MoveWindow {
    public int[] moveWindow(int[] nums, int k) {
        int num = 0;
        int br = nums.length - k;
        int[] mp = new int[br + 1];
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            num = i + k;
            int[] a = new int[num - i];
            for (int l = 0, j = i; j < num; j++, l++) {
                a[l] = nums[j];
            }
            mp[i] = Arrays.stream(Arrays.stream(a).toArray()).max().getAsInt();
            if (i == br) {
                break;
            }
        }
        return mp;
    }

    public static void main(String[] args) {
        int[] lm = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new MoveWindow().moveWindow(lm, 3);
        for (int k = 0; k < ints.length; k++) {
            System.out.println(ints[k]);
        }
    }
}
