package com.mrglint.leetcode.week05.solution120;

import java.util.Arrays;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-11-15 08:51
 */
public class Solution {

    /**
     * 递归
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        return minimumTotal3(0, 0, triangle);
    }
    private int minimumTotal3(int row, int col, List<List<Integer>> triangle) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        int left = minimumTotal3(row + 1, col, triangle);
        int right = minimumTotal3(row + 1, col + 1, triangle);
        return Math.min(left, right) + triangle.get(row).get(col);
    }

    /**
     * 递归 记忆化搜索
     * @param triangle
     * @return
     */
    private int[][] memo;
    public int minimumTotal2(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }
        return minimumTotal2(0, 0, triangle);
    }
    private int minimumTotal2(int row, int col, List<List<Integer>> triangle) {
        // 到最后一层，直接返回对应的值
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int left = minimumTotal2(row + 1, col, triangle);
        int right = minimumTotal2(row + 1, col + 1, triangle);
        memo[row][col] = Math.min(left, right) + triangle.get(row).get(col);
        return memo[row][col];
    }

    /**
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * 动态规划
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minLen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= triangle.get(level).size() - 1; i++) {
                minLen[i] = Math.min(minLen[i], minLen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minLen[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int minimumTotal = solution.minimumTotal3(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)));
        System.out.println(minimumTotal);
    }
}
