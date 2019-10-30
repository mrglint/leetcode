package com.mrglint.leetcode.week02.solution169;

/**
 * @author luhuancheng
 * @since 2019-10-29 07:11
 */
public class Solution {

    /**
     * 众数：出现次数大于一半的元素
     * 分治整个数组，直到数组长度为1，之后回溯到上层进行合并。如果两个合并的数组众数一样，那么得解。如果两个合并的数组众数不一样，那么统计两个数在合并后数组中的出现个数，大的是众数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }
    private int majorityElement(int[] nums, int lo, int hi) {
        // terminator
        if (lo == hi) {
            return nums[lo];
        }

        // split big problem and process logic
        int mid = lo + (hi - lo) / 2;
        int left = majorityElement(nums, lo, mid);
        int right = majorityElement(nums, mid + 1, hi);

        // merge result
        if (left == right) {
            return left;
        }
        int leftCount = countElement(nums, lo, hi, left);
        int rightCount = countElement(nums, lo, hi, right);
        return leftCount > rightCount ? left : right;

        // restore state

    }
    private int countElement(int[] nums, int lo, int hi, int num) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
