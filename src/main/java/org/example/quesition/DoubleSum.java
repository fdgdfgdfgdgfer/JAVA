package org.example.quesition;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/18 8:46
 * @PackageName:org.example.quesition
 * @ClassName: DoubleSum
 */
@Data
@NoArgsConstructor
public class DoubleSum {
    public String addStrings(String num1, String num2) {
        int numLength1 = 0;
        int numLength2 = 0;
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        int loop = 0;
        int num = 0;
        StringBuffer buffer = new StringBuffer();
        while (numLength1 <= length1 || numLength2 <= length2) {
            //进位
            int m1 = length1 >= 0 ? Character.getNumericValue(num1.charAt(length1)) : 0;
            int m2 = length2 >= 0 ? Character.getNumericValue(num2.charAt(length2)) : 0;
            num = m1 + m2 + loop;

            int lp = num % 10;
            buffer.append(lp);
            loop = num / 10;
            length2--;
            length1--;
        }
        if (loop == 1) {
            buffer.append(1);
        }
        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new DoubleSum().addStrings("99", "9");
        System.out.println(s);
    }
}
