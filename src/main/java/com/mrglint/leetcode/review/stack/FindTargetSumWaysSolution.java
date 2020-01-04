package com.mrglint.leetcode.review.stack;

/**
 * @author luhuancheng
 * @since 2019-12-26 08:02
 */
public class FindTargetSumWaysSolution {

    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        findTargetSumWays(nums, 0, 0, S);
        return count;
    }

    private void findTargetSumWays(int[] nums, int sum, int n, int target) {
        if (n == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            findTargetSumWays(nums, sum + nums[n], n + 1, target);
            findTargetSumWays(nums, sum - nums[n], n + 1, target);
        }
    }

}
