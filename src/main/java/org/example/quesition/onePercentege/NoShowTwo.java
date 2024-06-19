package org.example.quesition.onePercentege;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/4/29 11:44
 * @PackageName:org.example.quesition.onePercentege
 * @ClassName: NoShowTwo
 */

public class NoShowTwo {
    public static void main(String[] args) {
        boolean b = "sss".startsWith("sss");
        System.out.println(
                b
        );
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 1;
        int num = 0;
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                j++;
            } else {
                i++;
            }
            num = Math.max(num, j - i);
        }
        return num;
    }

}
