package com.mrglint.algorithm.dp;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-12-03 21:33
 */
public class UniquePathI {

    /**
     * m x n 矩阵，m为宽，n为高
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // 使用一个长度为 m 的数组来存储状态
        int[] dp = new int[m + 1];
        // 第一行的状态初始化为1，因为只能往右走
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[m - 1];
    }
}
