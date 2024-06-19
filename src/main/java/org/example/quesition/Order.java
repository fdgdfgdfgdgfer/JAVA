package org.example.quesition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/4/28 14:40
 * @PackageName:org.example.quesition
 * @ClassName: Order
 */
public class Order {
    public static void main(String[] args) {
        Order order = new Order();
        int[] arr = {6, 3, 1, 7, 9};
        order.merger(arr, 0, arr.length - 1);
        for (Integer a : arr) {
            System.out.println(a);
        }
    }

    public void merger(int[] arr, int left, int rig) {
        if (left >= rig) {
            return;
        }
        int inx = MySort(arr, left, rig);
        merger(arr, left, inx - 1);
        merger(arr, inx + 1, rig);
    }

    public int MySort(int[] arr, int left, int rig) {
        // write code here
        int i = left;
        int j = rig;
        while (i < j) {
            while (i < j && arr[j] >= arr[left])
                j--;
            while (i < j && arr[i] <= arr[left])
                i++;
            swap(arr, i, j);
        }
        swap(arr, left, i);
        return i;
    }

    public void swap(int[] arr, Integer inxOne, Integer inxTwo) {
        Integer temp = arr[inxOne];
        arr[inxOne] = arr[inxTwo];
        arr[inxTwo] = temp;
    }
}
