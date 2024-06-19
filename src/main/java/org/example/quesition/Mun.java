package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author jfz
 * @Date 2024/1/31 17:40
 * @PackageName:org.example.quesition
 * @ClassName: Mun
 */
@Data
@NoArgsConstructor
@Builder
public class Mun {

    public boolean isAnagram(String s, String t) {

        if (s.length() == 0) {
            return true;
        }

        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                if (++j == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //输入：s = "abc", t = "ahbgdc"
        //输出：true
        //s =
        //"axc"
        //t =
        //"ahbgdc"
        boolean anagram = new Mun().isAnagram("a", "ahbgdc");
        System.out.println(anagram);
    }

}
