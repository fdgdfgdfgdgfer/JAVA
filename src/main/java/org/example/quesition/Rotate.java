package org.example.quesition;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/18 10:23
 * @PackageName:org.example.quesition
 * @ClassName: Rotate
 */
@Data
@NoArgsConstructor
public class Rotate {
    public boolean rotateString(String s, String goal) {
        int i = s.length() - 1;
        String temp = s;
        while (i >= 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(temp.substring(1, temp.length())).append(temp.charAt( 0));
            if (buffer.toString().equals(goal)) {
                return true;
            }
            temp = buffer.toString();
            i--;
        }
        return false;
    }
    public static void main(String[] args) {
        boolean b = new Rotate().rotateString("abcde", "abced");
        System.out.println(b);
    }
}
