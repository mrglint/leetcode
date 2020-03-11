package com.mrglint.leetcode.year2020.queryset.solution1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2020-03-11 07:47
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }
            cache.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such result.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}
