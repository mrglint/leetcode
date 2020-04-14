package com.mrglint.leetcode.year2020.recurse.solution110;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-04-14 07:38
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxHeight(node.left), maxHeight(node.right)) + 1;
    }
}
