package com.mrglint.leetcode.year2020.array.solution27;

/**
 * @author luhuancheng
 * @since 2020-03-01 16:16
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        // [0, k) 区间内不包含val
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != k) {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                }
                k++;
            }
        }
        return k;
    }

}
