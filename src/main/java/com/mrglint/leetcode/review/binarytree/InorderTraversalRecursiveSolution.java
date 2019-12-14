package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-12-11 07:58
 */
public class InorderTraversalRecursiveSolution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorderTraversal(root.left, res);
            res.add(root.val);
            inorderTraversal(root.right, res);
        }
    }
}
