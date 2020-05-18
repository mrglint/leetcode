package com.mrglint.leetcode.year2020.tag.tree.interview.solution0405;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-05-19 07:33
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     *
     * @param node
     * @param lower 下界，即所有节点都要大于这个值
     * @param upper 上界，即所有节点都要小于这个值
     * @return
     */
    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if (lower != null && node.val <= lower) {
            return false;
        }

        if (upper != null && node.val >= upper) {
            return false;
        }

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
