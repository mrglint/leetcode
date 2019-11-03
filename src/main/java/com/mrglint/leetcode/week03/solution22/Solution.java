package com.mrglint.leetcode.week03.solution22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-10-31 22:02
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateParenthesis(0, 0, n, "", result);
        return result;
    }
    private void generateParenthesis(int left, int right, int n, String subResult, List<String> result) {
        if (left == n && right == n) {
            result.add(subResult);
            return;
        }

        if (left < n) {
            generateParenthesis(left + 1, right, n, subResult + "(", result);
        }
        if (left > right) {
            generateParenthesis(left, right + 1, n, subResult + ")", result);
        }
    }
}
