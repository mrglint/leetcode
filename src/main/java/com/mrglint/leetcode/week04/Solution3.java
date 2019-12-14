package com.mrglint.leetcode.week04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2019-11-10 21:07
 */
public class Solution3 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (cache.containsKey(search)) {
                return new int[]{cache.get(search), i};
            }
            cache.put(nums[i], i);
        }
        throw new RuntimeException("找不到结果");
    }
}
