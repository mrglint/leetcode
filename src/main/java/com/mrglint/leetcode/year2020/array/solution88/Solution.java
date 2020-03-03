package com.mrglint.leetcode.year2020.array.solution88;

/**
 *
 * @author luhuancheng
 * @since 2020-03-04 07:22
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;

        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[k] = nums1[i];
                    k--;
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    k--;
                    j--;
                }
            } else if (i >= 0){
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }
}
