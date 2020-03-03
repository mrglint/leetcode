package com.mrglint.leetcode.year2020.array.solution26;

/**
 * @author luhuancheng
 * @since 2020-03-01 16:32
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                if (k + 1 != i) {
                    int temp = nums[k + 1];
                    nums[k + 1] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
        return k + 1;
    }

}
