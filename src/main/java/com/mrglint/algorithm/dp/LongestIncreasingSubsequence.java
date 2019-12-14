package com.mrglint.algorithm.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 求最长递增子序列的长度
 * @author luhuancheng
 * @since 2019-12-03 08:31
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        // 以数组中每个数字结尾的子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);


        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
