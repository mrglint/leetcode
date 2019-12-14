package com.mrglint.leetcode.week05.solution63;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-12 08:04
 */
public class DivideAndConquerSolution {
    /**
     * 分治解法
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (!canWalk(0, 0, rows, cols, obstacleGrid)) {
            return 0;
        }
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return uniquePathsWithObstacles(0, 0, rows, cols, obstacleGrid, memo);
    }
    private int uniquePathsWithObstacles(int row, int col, int rows, int cols, int[][] obstacleGrid, int[][] memo) {
        if (row == rows - 1) {
            for (int i = col; i < cols; i++) {
                if (!canWalk(row, i, rows, cols, obstacleGrid)) {
                    return 0;
                }
            }
            return 1;
        }
        if (col == cols - 1) {
            for (int i = row; i < rows; i++) {
                if (!canWalk(i, col, rows, cols, obstacleGrid)) {
                    return 0;
                }
            }
            return 1;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        // 两条路线的可能走法
        if (canWalk(row, col + 1, rows, cols, obstacleGrid) && canWalk(row + 1, col, rows, cols, obstacleGrid)) {
            memo[row][col] = uniquePathsWithObstacles(row, col + 1, rows, cols, obstacleGrid, memo) + uniquePathsWithObstacles(row + 1, col, rows, cols, obstacleGrid, memo);
        } else if (!canWalk(row, col + 1, rows, cols, obstacleGrid) && !canWalk(row + 1, col, rows, cols, obstacleGrid)) {
            memo[row][col] = 0;
        } else if (!canWalk(row, col + 1, rows, cols, obstacleGrid)) {
            memo[row][col] = uniquePathsWithObstacles(row + 1, col, rows, cols, obstacleGrid, memo);
        } else {
            memo[row][col] = uniquePathsWithObstacles(row, col + 1, rows, cols, obstacleGrid, memo);
        }
        return memo[row][col];
    }
    private boolean canWalk(int row, int col, int rows, int cols, int[][] obstacleGrid) {
        return row < rows && col < cols && obstacleGrid[row][col] == 0;
    }
}
