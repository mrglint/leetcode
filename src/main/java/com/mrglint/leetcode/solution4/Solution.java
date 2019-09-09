package com.mrglint.leetcode.solution4;

/**
 * @author luhuancheng
 * @since 2019/9/9 7:25 上午
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // todo 更高级的解法
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums = new int[nums1.length + nums2.length];

        while (i < nums1.length && j < nums2.length) {
            if (less(nums1[i], nums2[j])) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            nums[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums[k++] = nums2[j++];
        }

        int mid = nums.length / 2;
        boolean oddLength = nums.length % 2 != 0;
        if (oddLength) {
            return nums[mid];
        } else {
            return (nums[mid - 1] + nums[mid]) / 2.0;
        }
    }

    private boolean less(int i, int j) {
        return i < j;
    }
}
