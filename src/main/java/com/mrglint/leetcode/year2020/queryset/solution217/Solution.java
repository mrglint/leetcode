package com.mrglint.leetcode.year2020.queryset.solution217;


import java.util.HashSet;
import java.util.Set;

/**
 * @author luhuancheng
 * @since 2020-03-15 21:29
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
