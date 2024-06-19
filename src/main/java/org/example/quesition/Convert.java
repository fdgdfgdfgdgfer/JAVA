package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jfz
 * @Date 2024/2/23 9:47
 * @PackageName:org.example.quesition
 * @ClassName: Convert
 */
@Data
@NoArgsConstructor
public class Convert {
    public String convert(String s, int numRows) {
        List<StringBuffer> str = new ArrayList<>();
        for (int a = 0; a < numRows ; a++) {
            str.add(new StringBuffer());
        }
        int i = 0;
        int flag = 1;
        for (char a : s.toCharArray()) {
            str.get(i).append(a);
            if (i == 0) {
                flag = 1;
            }
            if (i == numRows - 1) {
                flag = -1;
            }
            i += flag;
        }
        StringBuffer buffer = new StringBuffer();
        for (StringBuffer b : str) {
            buffer.append(b);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        //输入：s = "PAYPALISHIRING", numRows = 3
        //输出："PAHNAPLSIIGYIR"
        String paypalishiring = new Convert().convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
    }
}
