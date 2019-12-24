package com.mrglint.leetcode.review.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-22 10:55
 */
public class DailyTemperatureSolution {

    /**
     * 1. 从后往前遍历温度列表
     * 2. 如果栈不为空，且栈顶元素小于等于当前温度，则弹出栈顶元素（寻找比当前温度大的索引）
     * 3. 计算当前温度到栈顶元素的距离
     * 4. 放入当前温度索引
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            // T[i] >= T[stack.peek()] 找出在 i 天之后温度大于 i 天温度的天数
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatureSolution solution = new DailyTemperatureSolution();
        int[] ints = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
}
