package com.mrglint.leetcode.year2020.array.solution11;

/**
 * @author luhuancheng
 * @since 2020-03-05 07:47
 */
public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = Integer.MIN_VALUE;

        while (i < j) {
            result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
