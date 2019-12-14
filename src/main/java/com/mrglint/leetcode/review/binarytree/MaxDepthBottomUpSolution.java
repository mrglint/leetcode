package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2019-12-12 07:57
 */
public class MaxDepthBottomUpSolution {

    public int maxDepth(TreeNode root) {
        // 空节点，深度为0
        if (root == null) {
            return 0;
        }
        // 分别获取左子树、右子树最大深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
