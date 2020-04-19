package com.mrglint.leetcode.year2020.recurse.solution129;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-04-19 08:17
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        sumNumbers(root, res, "");
        return parseAndSum(res);
    }

    private void sumNumbers(TreeNode node, List<String> res, String numString) {
        numString = numString + node.val;
        if (node.left == null && node.right == null) {
            res.add(numString);
        }
        if (node.left != null) {
            sumNumbers(node.left, res, numString);
        }
        if (node.right != null) {
            sumNumbers(node.right, res, numString);
        }
    }

    private int parseAndSum(List<String> res) {
        return res.stream().mapToInt(Integer::valueOf).sum();
    }
}
