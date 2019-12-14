package com.mrglint.leetcode.week05.solution62;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-11 22:08
 */
public class Solution {

    /**
     * 分治解法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] memo = new int[n + 1][m + 1];
        return uniquePaths1(0, 0, m, n, memo);
    }
    private int uniquePaths1(int row, int col, int m, int n, int[][] memo) {
        if (row == n - 1 || col == m - 1) {
            return 1;
        }
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        memo[row][col] = uniquePaths1(row, col + 1, m, n, memo) + uniquePaths1(row + 1, col, m, n, memo);
        return memo[row][col];
    }

    /**
     * 动态规划解法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] states = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            states[i][m - 1] = 1;
        }
        for (int i = 0; i < m; i++) {
            states[n - 1][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                states[i][j] = states[i][j + 1] + states[i + 1][j];
            }
        }
        return states[0][1] + states[1][0];
    }

    /**
     * 压缩空间的动态规划解法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[] states = new int[m];
        Arrays.fill(states, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                states[j] = states[j - 1] + states[j];
            }
        }
        return states[m - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(51, 9));
    }
}
