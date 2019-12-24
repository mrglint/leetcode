package com.mrglint.leetcode.review.stack;

import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-17 07:46
 */
public class NumberOfIslandSolution {

    /**
     * 上、左、下、右四个方向的坐标偏移
     */
    private static final int[][] DIRESTIONS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * 1. 使用数组表示坐标 int[]{row, col}
     * 2. 使用数组记录已访问坐标 boolean[][] = new boolean[rows][cols]
     * 3. 借助stack后进先出的特性，实现「深度度优先」遍历算法
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Stack<int[]> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 没被访问过的、且值为'1'，进行一次深度优先遍历
                if (!visited[i][j] && grid[i][j] == '1') {
                    stack.push(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] coordinate = stack.pop();
                        visited[coordinate[0]][coordinate[1]] = true;
                        for (int n = 0; n < 4; n++) {
                            int newRow = coordinate[0] + DIRESTIONS[n][0];
                            int newCol = coordinate[1] + DIRESTIONS[n][1];
                            if (validateCoordinate(newRow, newCol, grid.length, grid[0].length) && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                                stack.push(new int[]{newRow, newCol});
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }

    private boolean validateCoordinate(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}
