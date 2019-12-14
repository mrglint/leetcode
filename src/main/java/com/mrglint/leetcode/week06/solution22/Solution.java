package com.mrglint.leetcode.week06.solution22;

import java.util.LinkedList;
import java.util.List;

/**
 * 1. 递归+剪枝
 * @author luhuancheng
 * @since 2019-11-22 08:31
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generateParenthesis(0, 0, n, "", result);
        return result;
    }

    private void generateParenthesis(int leftCount, int rightCount, int n, String temp, List<String> result) {
        if (leftCount == n && rightCount == n) {
            result.add(temp);
        }

        if (leftCount < n) {
            generateParenthesis(leftCount + 1, rightCount, n, temp + "(", result);
        }
        if (rightCount < n && leftCount > rightCount) {
            generateParenthesis(leftCount, rightCount + 1, n, temp + ")", result);
        }
    }
}
