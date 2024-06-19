package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/5 14:22
 * @PackageName:org.example.quesition
 * @ClassName: AddStrings
 */
@Data
@NoArgsConstructor
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuffer buffer = new StringBuffer();
        int minLength = Math.min(num1.length(), num2.length());
        int loop = 0;
        int all = 0;
        for (int i = minLength - 1; i >= 0; i--) {
            if (loop == 1) {
                all = num1.charAt(i) - '0' + num2.charAt(i) - '0' + 1;
            } else {
                all = num1.charAt(i) - '0' + (int) num2.charAt(i) - '0';
            }
            //是否有进位
            if (all > 10) {
                loop = 1;
                buffer.append(all % 10);
            } else {
                buffer.append(all);
            }
        }
        if (num1.length() > minLength) {
            buffer.append(num1.substring(minLength - 1, num1.length()));
        }
        if (num2.length() > minLength) {
            buffer.append(num2.substring(minLength - 1, num2.length()));
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String a = "aba";
        Integer b = getLongestPalindrome(a);
        System.out.println(b);
    }


    public static int fun(String s, int begin, int end) {
        //每个中心点开始扩展
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        //返回长度
        return end - begin - 1;
    }

    public static int getLongestPalindrome(String A) {
        int maxlen = 1;
        //以每个点为中心
        for (int i = 0; i < A.length() - 1; i++)
            //分奇数长度和偶数长度向两边扩展
            maxlen = Math.max(maxlen, Math.max(fun(A, i, i), fun(A, i, i + 1)));
        return maxlen;
    }
}
