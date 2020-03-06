package com.mrglint.leetcode.year2020.array.solution209;

/**
 * @author luhuancheng
 * @since 2020-03-05 07:53
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;

        // [lo, hi] 滑动窗口
        int lo = 0;
        int hi = -1;

        // 窗口中子数组元素之和
        int sum = 0;

        while (lo < nums.length) {
            if (hi + 1 < nums.length && sum < s) {
                sum += nums[++hi];
            } else {
                sum -= nums[lo++];
            }

            if (sum >= s) {
                result = Math.min(result, (hi - lo + 1));
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
