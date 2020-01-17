package com.mrglint.leetcode.review.recursioni;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-01-02 07:47
 */
public class PascalTriangleISolution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        generate(1, numRows, res);
        return res;
    }

    private void generate(int level, int numRows, List<List<Integer>> res) {
        if (level > numRows) {
            return;
        }
        res.add(new ArrayList<>());
        // 每一行第一个数字为1
        res.get(level - 1).add(1);

        for (int i = 1; i < level - 1; i++) {
            res.get(level - 1).add(res.get(level - 2).get(i - 1) + res.get(level - 2).get(i));
        }

        // 每一行的最后一个数字为1
        if (level - 1 > 0) {
            res.get(level - 1).add(1);
        }

        generate(level + 1, numRows, res);
    }
}
