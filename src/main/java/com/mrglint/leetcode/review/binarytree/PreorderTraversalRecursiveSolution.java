package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-12-11 07:45
 */
public class PreorderTraversalRecursiveSolution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversal(root, res);
        return res;
    }
    private void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left, res);
            preorderTraversal(root.right, res);
        }
    }
}
