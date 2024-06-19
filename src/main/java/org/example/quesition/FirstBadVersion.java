package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/7 9:02
 * @PackageName:org.example.quesition
 * @ClassName: FirstBadVersion
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        int m = 0;
        while (i <= j) {
            m = (i + j) / 2;
            if (isBadVersion(m)) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    boolean isBadVersion(int m) {
        return m == 1;
    }

    public static void main(String[] args) {
        int i = new FirstBadVersion().firstBadVersion(3);
        System.out.println(i);
    }
}
