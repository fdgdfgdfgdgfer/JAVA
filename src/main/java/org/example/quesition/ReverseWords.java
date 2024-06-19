package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

/**
 * @Author jfz
 * @Date 2024/2/2 10:45
 * @PackageName:org.example.quesition
 * @ClassName: ReverseWords
 */
@Data
@NoArgsConstructor
public class ReverseWords {
    public String reverseWords(String s) {
        if ("" == s) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        int i = s.length() - 1;
        int j = s.length() - 1;
        s = s.trim();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            buffer.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        //输入：s = "  hello world  "
        //输出："world hello"
        String s = "the sky is blue";
        String s1 = new ReverseWords().reverseWords(s);
        System.out.println(s1);
    }
}
