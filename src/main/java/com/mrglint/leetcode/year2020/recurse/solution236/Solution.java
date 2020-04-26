package com.mrglint.leetcode.year2020.recurse.solution236;

import com.mrglint.leetcode.TreeNode;

/**
 * 在普通二叉树中，根据给定的两个节点，求两个节点的最近公共祖先节点
 *
 * @author luhuancheng
 * @since 2020-04-26 07:26
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
