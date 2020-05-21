package com.mrglint.leetcode.year2020.tag.tree.solution530;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-05-22 07:32
 */
public class Solution {

    private int min = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        if (prev != null) {
            min = Math.min(Math.abs(node.val - prev.val), min);
        }

        prev = node;
        inOrder(node.right);
    }

}
