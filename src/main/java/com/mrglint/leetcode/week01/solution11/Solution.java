package com.mrglint.leetcode.week01.solution11;

/**
 * @author luhuancheng
 * @since 2019-10-17 08:56
 */
public class Solution {
    public int maxArea1(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area = (j - i) * minHeight;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
