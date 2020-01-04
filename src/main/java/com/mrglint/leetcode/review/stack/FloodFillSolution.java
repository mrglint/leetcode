package com.mrglint.leetcode.review.stack;

import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-28 09:18
 */
public class FloodFillSolution {

    /**
     * 上、左、下、右四个方向的坐标偏移
     */
    private static final int[][] DIRESTIONS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private boolean validateCoordinate(int row, int col, int rows, int cols, int[][] image, int originalColor) {
        return row >= 0 && row < rows && col >= 0 && col < cols && image[row][col] == originalColor;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) {
            return image;
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr, sc});
        int originalColor = image[sr][sc];
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            visited[pop[0]][pop[1]] = true;
            image[pop[0]][pop[1]] = newColor;
            for (int i = 0; i < 4; i++) {
                int newRow = pop[0] + DIRESTIONS[i][0];
                int newCol = pop[1] + DIRESTIONS[i][1];
                if (validateCoordinate(newRow, newCol, image.length, image[0].length, image, originalColor) && !visited[newRow][newCol]) {
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFillSolution solution = new FloodFillSolution();
        solution.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    }
}
