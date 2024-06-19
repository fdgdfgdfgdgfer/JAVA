package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/6 9:33
 * @PackageName:org.example.quesition
 * @ClassName: GenerateMatrix
 */
@Data
@NoArgsConstructor
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int low = 0, top = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++)
                ints[low][i] = num++;
            if (low++ > top) {
                break;
            }

            for (int i = low; i <= top; i++)
                ints[i][right] = num++;
            if (right-- < left) {
                break;
            }

            for (int i = right; i >= left; i--)
                ints[top][i] = num++;
            if (top-- < low) {
                break;
            }

            for (int i = top; i >= low; i--)
                ints[i][left] = num++;
            if (left++ > right) {
                break;
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        int[][] ints = new GenerateMatrix().generateMatrix(3);
        for (int[] a : ints) {
           for (int num :a){
               System.out.println(num);
           }
        }
    }
}
