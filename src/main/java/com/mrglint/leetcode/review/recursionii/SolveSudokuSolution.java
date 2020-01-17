package com.mrglint.leetcode.review.recursionii;

/**
 * 行：1-9数字不能重复
 * 列：1-9数字不能重复
 * 小方框：1-9数字不能重复
 *
 * @author luhuancheng
 * @since 2020-01-16 22:26
 */
public class SolveSudokuSolution {
    public void solveSudoku(char[][] board) {
        // 用下标 1 - 9 获取对应的数字在行、列、小方格是否放置。因此这里使用的空间大小为10
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] subArea = new boolean[9][10];

        // 初始化：如果字符不是'.',则填充到对应的数组中：rows、cols、subArea
        for (int row = 0; row < 9;row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int digit = Character.digit(board[row][col], 10);
                    rows[row][digit] = true;
                    cols[col][digit] = true;
                    int subAreaIndex = getSubAreaIndex(row, col);
                    subArea[subAreaIndex][digit] = true;
                }
            }
        }

        // 从第一格开始，尝试填充
        fillSudoku(rows, cols, subArea, board);

    }

    private boolean fillSudoku(boolean[][] rows, boolean[][] cols, boolean[][] subArea, char[][] board) {
        // 搜索九宫格中，可放入数字的空格。即 '.'
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // 存在空格，尝试以数字 1 - 9 填充
                if (board[row][col] == '.') {
                    for (int i = 1; i <= 9; i++) {
                        if (canPlace(row, col, rows, cols, subArea, i)) {
                            board[row][col] = Character.forDigit(i, 10);
                            // 记录已放置数字 i 到行、列、子九宫格
                            rows[row][i] = true;
                            cols[col][i] = true;
                            subArea[getSubAreaIndex(row, col)][i] = true;
                            // 继续处理下一个空格
                            if (fillSudoku(rows, cols, subArea, board)) {
                                return true;
                            }
                            // 回溯
                            rows[row][i] = false;
                            cols[col][i] = false;
                            subArea[getSubAreaIndex(row, col)][i] = false;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        // 遍历完了所有格子
        return true;
    }

    private boolean canPlace(int row, int col, boolean[][] rows, boolean[][] cols, boolean[][] subArea, int number) {
        return !rows[row][number] && !cols[col][number] && !subArea[getSubAreaIndex(row, col)][number];
    }

    /**
     * 将坐标 row, col 转换为小方格索引
     *
     * @param row
     * @param col
     * @return
     */
    private int getSubAreaIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }
}
