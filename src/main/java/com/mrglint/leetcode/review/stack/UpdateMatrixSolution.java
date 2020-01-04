package com.mrglint.leetcode.review.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2019-12-29 15:00
 */
public class UpdateMatrixSolution {

    /**
     * 上、左、下、右四个方向的坐标偏移
     */
    private static final int[][] DIRESTIONS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * 遍历数组：
     * 1. 如果数值为0则设置距离为0
     * 2. 如果数值非0，利用BFS遍历，找到了之后取所有遍历结果的最小值
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }

        Queue<int[]> queue = new LinkedList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dis = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            // 看下上、下、左、右四个方向的坐标
            for (int i = 0; i < 4; i++) {
                int newRow = coordinate[0] + DIRESTIONS[i][0];
                int newCol = coordinate[1] + DIRESTIONS[i][1];
                // 坐标合法且当前的距离大于本次计算出来的距离
                if (validateCoordinate(newRow, newCol, rows, cols) && dis[newRow][newCol] > dis[coordinate[0]][coordinate[1]] + 1) {
                    queue.offer(new int[]{newRow, newCol});
                    dis[newRow][newCol] = dis[coordinate[0]][coordinate[1]] + 1;
                }
            }
        }
        return dis;
    }

    private boolean validateCoordinate(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
