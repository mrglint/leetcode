package com.mrglint.leetcode.week02.solution77;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-10-27 15:07
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        findCombinations(n, k, 1, new Stack<>(), result);
        return result;
    }

    private void findCombinations(int n, int k, int begin, Stack<Integer> pre, List<List<Integer>> result) {
        if (pre.size() == k) {
            result.add(new ArrayList<>(pre));
        }

        for (int i = begin; i <= n; i++) {
            pre.add(i);
            findCombinations(n, k, i + 1, pre, result);
            pre.pop();
        }
    }
}
