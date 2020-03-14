package com.mrglint.leetcode.year2020.queryset.solution16;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2020-03-13 21:57
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        // 保持有序，双指针的前提条件
        Arrays.sort(nums);

        int diff = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                // nums[l] + nums[r] 要接近的数字
                int t = target - nums[i];
                if (nums[l] + nums[r] == t) {
                    return nums[l] + nums[r] + nums[i];
                }

                if (Math.abs(nums[l] + nums[r] + nums[i] - target) < diff) {
                    res = nums[i] + nums[l] + nums[r];
                    diff = Math.abs(nums[l] + nums[r] + nums[i] - target);
                }
                if (nums[l] + nums[r] < t) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
