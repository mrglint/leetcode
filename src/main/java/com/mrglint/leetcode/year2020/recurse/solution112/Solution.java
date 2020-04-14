package com.mrglint.leetcode.year2020.recurse.solution112;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-04-15 07:25
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
