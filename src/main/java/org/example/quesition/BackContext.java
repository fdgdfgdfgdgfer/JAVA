package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author jfz
 * @Date 2024/2/1 10:50
 * @PackageName:org.example.quesition
 * @ClassName: BackContext
 */
@Data
@NoArgsConstructor
@Builder
public class BackContext {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.containsKey(c) ? hashMap.get(c) + 1 : 1);
        }
        int totalNum = 0;
        int odd = 0;
        for (Character character : hashMap.keySet()) {
            Integer integer = hashMap.get(character);
            int parity = integer % 2;
            totalNum += (integer - parity);
            if (parity == 1) {
                odd = 1;
            }
        }
        return totalNum + odd;
    }


}
