package com.mrglint.algorithm.dp;

/**
 * @author luhuancheng
 * @since 2019-12-07 22:38
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] robFirstHourse = new int[nums.length - 1];
        int[] robLastHourse = new int[nums.length - 1];
        System.arraycopy(nums, 0, robFirstHourse, 0, nums.length - 1);
        System.arraycopy(nums, 1, robLastHourse, 0, nums.length - 1);
        return Math.max(chooseRob(robFirstHourse), chooseRob(robLastHourse));
    }

    private int chooseRob(int[] nums) {
        int prevMax = 0;
        int curMax = 0;
        for (int i : nums) {
            int temp = curMax;
            curMax = Math.max(prevMax + i, curMax);
            prevMax = temp;
        }
        return curMax;
    }
}
