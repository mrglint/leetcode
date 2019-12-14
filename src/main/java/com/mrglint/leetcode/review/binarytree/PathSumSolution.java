package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2019-12-12 22:51
 */
public class PathSumSolution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
