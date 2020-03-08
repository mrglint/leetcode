package com.mrglint.leetcode.year2020.queryset.solution349;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 问题变种：数组的元素有序
 *
 * @author luhuancheng
 * @since 2020-03-08 14:21
 */
public class SolutionWithOrder {

    public int[] intersection(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                // nums1[i] < nums2[j]
                i++;
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int[] res = new int[list.size()];
        for (int n = 0; n < list.size(); n++) {
            res[n] = list.get(n);
        }
        return res;
    }

}
