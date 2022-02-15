package com.mrglint.leetcode.year2022.solution560;

/**
 * @author luhuancheng
 * @since 2022/2/15 7:52 AM
 */
public class Solution {

    public int subarraySum(int[] nums, int k) {
        int m = nums.length;
        int[] preSum = new int[m + 1];

        // 记录前缀和
        for (int i = 1; i <= m; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }

}
