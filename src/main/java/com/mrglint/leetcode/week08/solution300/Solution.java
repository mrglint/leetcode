package com.mrglint.leetcode.week08.solution300;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-12-08 22:42
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        // [10,9,2,5,3,7,101,18]
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
