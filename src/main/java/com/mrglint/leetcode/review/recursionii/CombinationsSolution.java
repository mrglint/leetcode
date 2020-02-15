package com.mrglint.leetcode.review.recursionii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/
 *
 * @author luhuancheng
 * @since 2020-01-20 08:31
 */
public class CombinationsSolution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        combine(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void combine(int first, int n, int k, List<Integer> subRes, List<List<Integer>> res) {
        if (subRes.size() == k) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        for (int i = first; i <= n; i++) {
            subRes.add(i);
            combine(i + 1, n, k, subRes, res);
            // 回溯
            subRes.remove(subRes.size() - 1);
        }
    }
}
