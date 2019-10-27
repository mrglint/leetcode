package com.mrglint.leetcode.week02.solution236;

import com.mrglint.leetcode.TreeNode;

/**
 * @author luhuancheng
 * @since 2019-10-27 14:30
 */
public class Solution {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }
        // 左子树找p或q
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        // 右子树找p或q
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
        // 当前节点找p或q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // 如果从以上三个地方 有两个找到了p、q 那么当前节点就是其最近的公共祖先
        if (mid + left + right >= 2) {
            ans = currentNode;
        }

        return (mid + left + right) > 0;
    }
}
