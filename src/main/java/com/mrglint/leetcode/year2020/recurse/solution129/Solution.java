package com.mrglint.leetcode.year2020.recurse.solution129;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-04-19 08:17
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int preNum) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.val + preNum * 10;
        }
        return sumNumbers(node.left, node.val + preNum * 10) + sumNumbers(node.right, node.val + preNum * 10);
    }
}
