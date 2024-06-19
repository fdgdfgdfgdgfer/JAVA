package org.example.quesition;

public class MaxArray {
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,-3,4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }
}

