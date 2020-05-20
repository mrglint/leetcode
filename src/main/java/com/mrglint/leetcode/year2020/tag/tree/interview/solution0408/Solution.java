package com.mrglint.leetcode.year2020.tag.tree.interview.solution0408;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-05-21 07:31
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
