package com.mrglint.leetcode.review.recursionii;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
 * 在矩阵中，寻找目标值target，矩阵特性：
 * 1. 每行的元素从左到右升序排列。
 * 2. 每列的元素从上到下升序排列。
 *
 * @author luhuancheng
 * @since 2020-01-11 07:27
 */
public class SearchMatrixSolution {

    /**
     * 如何分治？
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;

        return searchMatrix(0, 0, row - 1, col - 1, row, col, matrix, target);
    }

    private boolean searchMatrix(int leftRow, int leftCol, int rightRow, int rightCol, int row, int col, int[][] martrix, int target) {
        // 坐标越界
        if (leftRow > rightRow || leftCol > rightCol || leftRow >= row || leftCol >= col) {
            return false;
        }

        if (leftRow == rightRow && leftCol == rightCol) {
            return martrix[leftRow][leftCol] == target;
        }

        // (leftRow + rightRow) / 2
        int midRow = leftRow + ((rightRow - leftRow) >> 1);
        int midCol = leftCol + ((rightCol - leftCol) >> 1);
        int temp = martrix[midRow][midCol];

        if (temp == target) {
            return true;
        } else if (temp > target) {
            return searchMatrix(leftRow, leftCol, midRow, midCol, row, col, martrix, target) ||
                    searchMatrix(leftRow, midCol + 1, midRow, rightCol, row, col, martrix, target) ||
                    searchMatrix(midRow + 1, leftCol, rightRow, midCol, row, col, martrix, target);
        } else {
            return searchMatrix(leftRow, midCol + 1, midRow, rightCol, row, col, martrix, target) ||
                    searchMatrix(midRow + 1, leftCol, rightRow, midCol, row, col, martrix, target) ||
                    searchMatrix(midRow + 1, midCol + 1, rightRow, rightCol, row, col, martrix, target);
        }
    }
}
