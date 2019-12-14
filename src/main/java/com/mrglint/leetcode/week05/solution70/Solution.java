package com.mrglint.leetcode.week05.solution70;

/**
 * @author luhuancheng
 * @since 2019-11-11 22:20
 */
public class Solution {

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    /**
     * 记忆化搜索
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] memo = new int[n + 1];
        return climbStairs1(n, memo);
    }
    private int climbStairs1(int n, int[] memo) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = climbStairs1(n - 1, memo) + climbStairs1(n - 2, memo);
        return memo[n];
    }
}
