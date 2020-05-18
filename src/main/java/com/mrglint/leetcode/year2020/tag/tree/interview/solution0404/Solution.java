package com.mrglint.leetcode.year2020.tag.tree.interview.solution0404;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-05-18 08:22
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = help(root.left);
        int rightHeight = help(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int help(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(help(node.left), help(node.right));
    }
}
