package com.mrglint.leetcode.year2020.recurse.solution104;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-04-08 07:46
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
