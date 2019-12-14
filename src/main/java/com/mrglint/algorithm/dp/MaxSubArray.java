package com.mrglint.algorithm.dp;

/**
 * @author luhuancheng
 * @since 2019-12-07 08:15
 */
public class MaxSubArray {

    /**
     * 假设数组长度为i，求最大子序列和可以拆解为子问题
     * f(i) = max(f(i - 1) + nums[i], nums[i])
     * 前一个子序列的和 + 当前值 和 当前值相比，取两者最大值
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
