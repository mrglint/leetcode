package com.mrglint.leetcode.year2020.recurse.solution124;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-05-01 22:24
 */
public class Solution {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        help(root);
        return ans;
    }

    private int help(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, help(node.left));
        int right = Math.max(0, help(node.right));

        ans = Math.max(ans, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
