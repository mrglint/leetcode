package com.mrglint.leetcode.year2020.recurse.solution235;

import com.mrglint.leetcode.TreeNode;

/**
 * 在二叉搜索树root中，寻找节点p、q两者的最低公共祖先
 *
 * @author luhuancheng
 * @since 2020-04-21 07:49
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
