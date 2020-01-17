package com.mrglint.leetcode.review.recursionii;

import com.mrglint.leetcode.TreeNode;

import java.util.Objects;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
 *
 * @author luhuancheng
 * @since 2020-01-10 07:39
 */
public class ValidBSTTreeSolution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, TreeNode lower, TreeNode upper) {
        if (Objects.isNull(node)) {
            return true;
        }
        if (Objects.nonNull(lower) && node.val <= lower.val) {
            return false;
        }
        if (Objects.nonNull(upper) && node.val >= upper.val) {
            return false;
        }
        // 左子树的所有节点的值不能 >= node.val
        if (!isValidBST(node.left, lower, node)) {
            return false;
        }
        // 右子树的所有节点的值不能 <= node.val
        if (!isValidBST(node.right, node, upper)) {
            return false;
        }
        return true;
    }
}
