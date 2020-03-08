package com.mrglint.leetcode.year2020.queryset.solution349;


import java.util.*;

/**
 * @author luhuancheng
 * @since 2020-03-08 14:21
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums1) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
