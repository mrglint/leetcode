package com.mrglint.leetcode.week05.solution63;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-12 22:21
 */
public class Solution {

    /**
     * 二维空间 - 动态规划
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] states = new int[rows][cols];

        // 起点
        states[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        if (states[0][0] == 0) {
            return 0;
        }

        // 第一列
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 0) {
                states[i][0] = states[i - 1][0];
            }
        }
        // 第一行
        for (int j = 1; j < cols; j++) {
            if (obstacleGrid[0][j] == 0) {
                states[0][j] = states[0][j - 1];
            }
        }
        // 递推
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] != 1) {
                    states[i][j] = states[i][j - 1] + states[i - 1][j];
                }
            }
        }
        return states[rows - 1][cols - 1];
    }

    /**
     * 一维空间 动态规划
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] states = new int[cols];
        Arrays.fill(states, 0);

        // 起点
        states[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        if (states[0] == 0) {
            return 0;
        }
        // 第一行
        for (int i =  1; i < cols; i++) {
            if (obstacleGrid[0][i] == 0) {
                states[i] = states[i - 1];
            }
        }

        // 递推
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    states[j] = obstacleGrid[i][j] == 1 ? 0 : states[j];
                } else {
                    if (obstacleGrid[i][j] == 0) {
                        states[j] = states[j] + states[j - 1];
                    } else {
                        states[j] = 0;
                    }
                }
            }
        }
        return states[cols - 1];
    }

    /**
     * 动态规划 一维空间 简洁写法
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = new int[][]{{0}, {1}};
        int result = solution.uniquePathsWithObstacles(data);
        System.out.println(result);
    }

}
