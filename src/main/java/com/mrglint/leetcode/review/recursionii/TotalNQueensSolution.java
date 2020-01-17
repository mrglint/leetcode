package com.mrglint.leetcode.review.recursionii;

import java.util.HashSet;
import java.util.Set;

/**
 * n皇后棋盘，有多少种方式可以放置皇后的位置，保证不互相攻击
 *
 * @author luhuancheng
 * @since 2020-01-13 08:00
 */
public class TotalNQueensSolution {
    int res = 0;

    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        totalNQueens(0, n, col, pie, na);
        return res;
    }

    private void totalNQueens(int row, int n, Set<Integer> col, Set<Integer> pie, Set<Integer> na) {
        // 递归到底,说明每一行我们都放置了棋子，是一种放置的方法
        if (row == n) {
            res++;
        }
        for (int c = 0; c < n; c++) {
            // 发生冲突，不能放
            if (col.contains(c) || pie.contains(row + c) || na.contains(row - c)) {
                continue;
            }
            col.add(c);
            pie.add(row + c);
            na.add(row - c);

            // 下一行
            totalNQueens(row + 1, n, col, pie, na);

            // 回溯
            col.remove(c);
            pie.remove(row + c);
            na.remove(row - c);
        }
    }

}
