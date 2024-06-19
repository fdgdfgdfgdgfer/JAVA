package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author jfz
 * @Date 2024/2/26 15:00
 * @PackageName:org.example.quesition
 * @ClassName: SpiralOrder
 */
@Data
@NoArgsConstructor
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int t = 0, b = matrix.length - 1, l = 0, r = matrix[0].length - 1, X = 0;
        List<Integer> result = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++)
                result.add(X++, matrix[t][i]);
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++)
                result.add(X++, matrix[i][r]);
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--)
                result.add(X++, matrix[b][i]);
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t; i--)
                result.add(X++, matrix[i][l]);
            if (++l > r) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String format = LocalDate.now().plusMonths(-1).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println(format);

    }

}
