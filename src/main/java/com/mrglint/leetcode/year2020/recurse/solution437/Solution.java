package com.mrglint.leetcode.year2020.recurse.solution437;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-04-20 07:37
 */
public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 从根节点找、从左子树找、从右子树找
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        if (node.val == sum) {
            res += 1;
        }
        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }
}
