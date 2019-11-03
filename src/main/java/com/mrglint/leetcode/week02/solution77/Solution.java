package com.mrglint.leetcode.week02.solution77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-10-27 15:07
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void combine(int begin, int n, int k, List<Integer> subResult, List<List<Integer>> result) {
        // 组合个数达到要求
        if (subResult.size() == k) {
            result.add(subResult);
            return;
        }
        // 选中当前数值，带上当前层的中间结果，继续往下一层递归
        for (int i = begin; i <= n; i++) {
            subResult.add(i);
            combine(i + 1, n, k, new ArrayList<>(subResult), result);
            subResult.remove(subResult.size() - 1);
        }
    }
}
