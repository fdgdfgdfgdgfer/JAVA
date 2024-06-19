package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author jfz
 * @Date 2024/2/2 13:41
 * @PackageName:org.example.quesition
 * @ClassName: LengthOfLongestSubstring
 */
@Data
@NoArgsConstructor
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> characters = new HashSet<>();
            characters.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!characters.add(s.charAt(j))) {
                    if (j - i > temp) {
                        temp = j - i;
                    }
                    break;
                }
                if (j == s.length() - 1) {
                    if (j - i >= temp) {
                        temp = j - i + 1;
                    }
                }

            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int abcabcbb = new LengthOfLongestSubstring().lengthOfLongestSubstring("aab");
        System.out.println(abcabcbb);
    }
}
