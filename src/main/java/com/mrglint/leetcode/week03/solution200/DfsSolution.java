package com.mrglint.leetcode.week03.solution200;

/**
 * @author luhuancheng
 * @since 2019-11-02 22:40
 */
public class DfsSolution {

    /**
     * 声明坐标位上「上、左、下、右」四个位置的偏移量
     */
    private int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * 全局变量 存储结果
     */
    private int count = 0;

    /**
     * 使用深度优先遍历
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        /*
        空间为空
         */
        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                /*
                1. 处于该二维数组表示的区域内
                2. 未被访问过
                3. 坐标值所在的元素为岛屿区域，即坐标所在的值为1
                 */
                if (!visited[row][col] && grid[row][col] == '1') {
                    count++;
                    floodFill(row, col, visited, rows, cols, grid);
                }
            }
        }
        return count;
    }

    private void floodFill(int row, int col, boolean[][] visited, int rows, int cols, char[][] grid) {
        visited[row][col] = true;
        for (int i = 0 ; i < directions.length; i++) {
            int newRow = directions[i][0] + row;
            int newCol = directions[i][1] + col;
            if (inArea(newRow, newCol, rows, cols) && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                floodFill(newRow, newCol, visited, rows, cols, grid);
            }
        }
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
