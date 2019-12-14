package com.mrglint.algorithm.dp;

/**
 * @author luhuancheng
 * @since 2019-12-07 09:10
 */
public class Rob {
    public int rob(int[] nums) {
        int prevMax = 0;
        int curMax = 0;
        for (int i : nums) {
            int temp = curMax;
            curMax = Math.max(prevMax + i, curMax);
            prevMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int rob1 = rob.rob(new int[]{2, 1, 1, 2});
        System.out.println(rob1);
    }
}
