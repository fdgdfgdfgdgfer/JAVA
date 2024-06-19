package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

/**
 * @Author jfz
 * @Date 2024/2/19 9:07
 * @PackageName:org.example.quesition
 * @ClassName: ValidateStackSequences
 */
@Data
@NoArgsConstructor
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> integers = new LinkedList<>();
        int i = 0, j = 0;
        for (int num : pushed) {
            integers.push(num);

            while (!integers.isEmpty() && integers.peek() == popped[j]) {
                integers.pop();
                j++;
            }
        }
        return integers.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4,5,3,2,1};
        boolean b1 = new ValidateStackSequences().validateStackSequences(a, b);
        System.out.println(b1);
    }
}
