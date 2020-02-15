package com.mrglint.leetcode.review.recursionii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2772/
 *
 * @author luhuancheng
 * @since 2020-01-20 10:48
 */
public class GenerateParenthesisSolution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(0, 0, "", n, res);
        return res;
    }

    private void generateParenthesis(int leftCount, int rightCount, String parenthesis, int n, List<String> res) {
        // 右括号已达到最大个数
        if (rightCount == n) {
            res.add(parenthesis);
            return;
        }
        // 左括号未达到配额n时，可以直接加
        if (leftCount < n) {
            generateParenthesis(leftCount + 1, rightCount, parenthesis + "(", n, res);
        }
        // 右括号的个数小于左括号，可以直接加右括号
        if (rightCount < leftCount) {
            generateParenthesis(leftCount, rightCount + 1, parenthesis + ")", n, res);
        }
    }
}
