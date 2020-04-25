package com.mrglint.leetcode.year2020.recurse.solution230;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2020-04-25 07:46
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNode(root.left);
        if (k <= count) {
            // 第 k 小元素在root树的左子树中
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            // 第 k 小元素在root树的右子树中, k - 1 - count ：去掉左子树和当前节点的节点数总和
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    private int countNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNode(node.left) + countNode(node.right);
    }
}
