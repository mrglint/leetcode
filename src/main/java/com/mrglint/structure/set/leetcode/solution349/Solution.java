package com.mrglint.structure.set.leetcode.solution349;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/submissions/
 * @author luhuancheng
 * @since 2020-02-22 11:01
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i : nums1) {
            numsSet.add(i);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (numsSet.contains(i)) {
                list.add(i);
                numsSet.remove(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
