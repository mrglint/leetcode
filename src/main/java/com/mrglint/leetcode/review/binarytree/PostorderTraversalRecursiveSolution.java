package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-12-11 13:05
 */
public class PostorderTraversalRecursiveSolution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            postorderTraversal(root.left, res);
            postorderTraversal(root.right, res);
            res.add(root.val);
        }
    }
}
