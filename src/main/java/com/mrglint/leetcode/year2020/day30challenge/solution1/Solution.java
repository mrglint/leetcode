package com.mrglint.leetcode.year2020.day30challenge.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luhuancheng
 * @since 2020-04-03 08:26
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.singleNumber(new int[]{2, 2, 1000});
        System.out.println(i);
    }
}
