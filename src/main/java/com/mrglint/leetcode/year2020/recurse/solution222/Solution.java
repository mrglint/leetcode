package com.mrglint.leetcode.year2020.recurse.solution222;

import com.mrglint.leetcode.TreeNode;

/**
 * 求满二叉树的
 * @author luhuancheng
 * @since 2020-04-12 21:40
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        if (root.left != null) {
            return 1 + countNodes(root.left);
        }
        if (root.right != null) {
            return 1 + countNodes(root.right);
        }
        // 左右子树都为空
        return 1;
    }
}
