package com.mrglint.leetcode.year2020.array.solution80;


import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2020-03-02 08l:11
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    // 0,1,1,1,1,1,1
    public int removeDuplicates1(int[] nums) {
        int j = 0;
        int repeat = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                repeat++;
                if (repeat <= 2) {
                    nums[++j] = nums[i];
                }
            } else {
                nums[++j] = nums[i];
                repeat = 1;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{1, 1, 2, 2, 2, 2};
        int i = solution.removeDuplicates1(data);
        System.out.println("return " + i + " - " + Arrays.toString(data));
    }


}
