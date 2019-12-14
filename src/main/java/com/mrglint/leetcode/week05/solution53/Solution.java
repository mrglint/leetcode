package com.mrglint.leetcode.week05.solution53;

import java.util.Arrays;

/**
 * 机器思维，找到自相似性（重复性）
 *
 * @author luhuancheng
 * @since 2019-11-17 21:11
 */
public class Solution {
    public int maxSubArray1(int[] nums) {
        // 1. 分治（子问题） max_sum(i) = Max(max_sum(i - 1), 0) + nums[i] 以nums[i]作为结尾，且子序列包含nums[i]的最大序列和
        // 2. 状态定义 f[i]
        // 3. DP方程 f(i) = Max(f(i - 1), 0) + nums[i]

        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * 简化
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-1, -2}));
    }
}
