package org.example.quesition.onePercentege;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author jfz
 * @Date 2024/4/29 12:00
 * @PackageName:org.example.quesition.onePercentege
 * @ClassName: NoRepeat
 */

public class NoRepeat {
    public static void main(String[] arg) {

        System.out.print(new NoRepeat().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        Set<Character> hash = new HashSet<Character>();
        int j = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hash.size() > 0) {
                hash.remove(s.charAt(i - 1));
            }
            while (j < s.length() && !hash.contains(s.charAt(j))) {
                hash.add(s.charAt(j));
                j++;

                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}
