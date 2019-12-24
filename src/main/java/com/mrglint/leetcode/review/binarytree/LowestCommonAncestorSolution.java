package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2019-12-15 07:54
 */
public class LowestCommonAncestorSolution {

    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
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
