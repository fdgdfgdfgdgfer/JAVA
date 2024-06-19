package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/4/28 16:46
 * @PackageName:org.example.quesition
 * @ClassName: Greedy
 */

public class Greedy {
    public static void main(String[] args) {
        int a = new Greedy().greedy("aba");
        System.out.println(a);
    }

    public int greedy(String str) {
        Integer num = 1;
        for (int i = 0; i < str.length(); i++) {
            num = Math.max(num, Math.max(find(str, i, i),
                    find(str, i, i + 1)));
        }
        return num;
    }

    public int find(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            end++;
            begin--;
        }
        return end - begin - 1;
    }

}
