package com.mrglint.leetcode.year2020.queryset.solution350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2020-03-08 14:31
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer n : nums1) {
            if (!freq.containsKey(n)) {
                freq.put(n, 1);
            } else {
                freq.put(n, freq.get(n) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Integer n : nums2) {
            int count = freq.getOrDefault(n, 0);
            if (count != 0) {
                list.add(n);
                count--;
                if (count == 0) {
                    freq.remove(n);
                } else {
                    freq.put(n, count);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
