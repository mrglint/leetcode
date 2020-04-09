package com.mrglint.leetcode.year2020.recurse.solution111;

import com.mrglint.leetcode.TreeNode;

/**
 * 到叶子节点的最小深度
 *
 * @author luhuancheng
 * @since 2020-04-10 07:21
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 如果root拥有一个子树，那么返回该子树的深度
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }

        // 如果root拥有两个子树，那么比较两个子树的深度，取最小
        return Math.min(left, right) + 1;
    }
}
