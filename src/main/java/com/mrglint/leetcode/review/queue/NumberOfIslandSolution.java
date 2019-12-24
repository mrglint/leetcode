package com.mrglint.leetcode.review.queue;

import java.util.LinkedList;
import java.util.Queue;

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
     * 3. 借助queue先进先出的特性，实现「广度优先」遍历算法
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        // 记录已访问坐标
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    res++;
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});

                    while (!queue.isEmpty()) {
                        int[] coordination = queue.poll();
                        for (int[] direction : DIRESTIONS) {
                            int newRow = coordination[0] + direction[0];
                            int newCol = coordination[1] + direction[1];
                            // 坐标不越界，合法
                            // 未被访问过
                            // 为岛屿坐标
                            if (validateCoordinate(newRow, newCol, rows, cols) && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                                visited[newRow][newCol] = true;
                                queue.offer(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean validateCoordinate(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }


}
