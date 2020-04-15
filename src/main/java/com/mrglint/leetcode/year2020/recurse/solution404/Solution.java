package com.mrglint.leetcode.year2020.recurse.solution404;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-04-16 07:28
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
