package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2019-12-12 07:43
 */
public class MaxDepthTopDownSolution {

    private int res = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 1);
        return res;
    }

    private void maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 到达根节点，更新最大深度
        if (node.left == null && node.right == null) {
            res = Math.max(depth, res);
        }
        // 只要 node.left 或者 node.right 有一个为非空节点，说明 node 不是叶子节点，深度 + 1后向下递归
        maxDepth(node.left, depth + 1);
        maxDepth(node.right, depth + 1);
    }
}
