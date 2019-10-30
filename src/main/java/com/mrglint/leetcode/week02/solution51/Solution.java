package com.mrglint.leetcode.week02.solution51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author luhuancheng
 * @since 2019-10-29 08:45
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();

        Set<Integer> colSet = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        solveNQueens(0, n, colSet, pie, na, subResult, result);
        return renderResult(result);
    }
    private List<List<String>> renderResult(List<List<Integer>> result) {
        List<List<String>> stringResult = new ArrayList<>();
        for (List<Integer> subResult : result) {
            List<String> subResultString = new ArrayList<>();
            for (Integer i : subResult) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < subResult.size(); j++) {
                    if (j != i) {
                        stringBuilder.append('.');
                    } else {
                        stringBuilder.append('Q');
                    }
                }
                subResultString.add(stringBuilder.toString());
            }
            stringResult.add(subResultString);
        }
        return stringResult;
    }
    private void solveNQueens(int row, int n, Set<Integer> colSet, Set<Integer> pie, Set<Integer> na, List<Integer> subResult, List<List<Integer>> result) {
        if (row == n) {
            result.add(subResult);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            colSet.add(col);
            pie.add(row + col);
            na.add(row - col);
            subResult.add(col);
            // 到下一层寻找
            solveNQueens(row + 1, n, colSet, pie, na, new ArrayList<>(subResult), result);

            colSet.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            subResult.remove(subResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(8);
        System.out.println(lists.size());
    }
}
