package com.mrglint.leetcode.year2020.recurse.solution98;

import com.mrglint.leetcode.TreeNode;

import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2020-04-22 07:42
 */
public class Solution {
    /**
     * 每个节点都比其左子树中的节点大、都比其右子树中的节点小
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * @param node
     * @param upper 上界
     * @param lower 下界
     * @return
     */
    private boolean isValidBST(TreeNode node, TreeNode upper, TreeNode lower) {
        // 空节点视为一棵二叉搜索树
        if (Objects.isNull(node)) {
            return true;
        }

        if (Objects.nonNull(upper) && node.val >= upper.val) {
            return false;
        }
        if (Objects.nonNull(lower) && node.val <= lower.val) {
            return false;
        }

        // 左子树的所有节点上界为 node、下界为lower
        if (!isValidBST(node.left, node, lower)) {
            return false;
        }
        // 右子树的所有节点上界为 upper、下界为node
        if (!isValidBST(node.right, upper, node)) {
            return false;
        }
        return true;
    }
}
