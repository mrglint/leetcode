package com.mrglint.leetcode.review.recursionii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/
 *
 * @author luhuancheng
 * @since 2020-01-09 07:47
 */
public class SortArraySolution {

    public List<Integer> sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return asList(nums);
    }

    private void sortArray(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        sortArray(nums, lo, mid);
        sortArray(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int i = lo, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= hi) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= hi) {
            tmp[k++] = nums[j++];
        }
        // 放回原数组
        for (int i1 = 0; i1 < tmp.length; i1++) {
            nums[lo + i1] = tmp[i1];
        }
    }

    private List<Integer> asList(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
}
