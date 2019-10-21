package com.mrglint.leetcode.solution84;

import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-10-21 07:02
 */
public class Solution {
    // 暴力解法
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        // 固定左边界
        for (int i = 0; i < heights.length; i++) {
            // 滑动右边界
            for (int j = i; j < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                // 寻找左边界到右边界之间最小的高度
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    // 优化后的暴力解法
    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // 让栈保持从栈底到栈顶递增的顺序
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // heights[stack.pop()] 拿到了最大高度
                // i所在的位置是最大高度的右边界
                // stack.peek()是最大高度的左边界
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            // 遍历过程中，将最大高度依次放入栈中
            stack.push(i);
        }
        // 不断回溯之前遍历过的元素
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
