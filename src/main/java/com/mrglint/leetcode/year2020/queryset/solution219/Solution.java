package com.mrglint.leetcode.year2020.queryset.solution219;


import java.util.HashSet;
import java.util.Set;

/**
 * @author luhuancheng
 * @since 2020-03-15 21:12
 */
public class Solution {

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
